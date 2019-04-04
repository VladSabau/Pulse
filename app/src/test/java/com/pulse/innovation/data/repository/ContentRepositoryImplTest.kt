package com.pulse.innovation.data.repository

import com.pulse.innovation.BaseTest
import com.pulse.innovation.data.model.Content
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

/**
 * Created by Vlad Sabau on 04.04.19.
 */
class ContentRepositoryImplTest: BaseTest() {

    private val localData = mockk<LocalData>(relaxed = true)
    private val remoteData = mockk<RemoteData>(relaxed = true)

    var repository: ContentRepositoryImpl = ContentRepositoryImpl(localData, remoteData)

    val testScheduler = TestScheduler()

    @Before
    fun before() {
        RxJavaPlugins.setComputationSchedulerHandler { testScheduler }
        repository = ContentRepositoryImpl(localData, remoteData)
    }

    @Test
    fun `when retrofit call get data insert in dataBase`() {
        val contentList = getMockContentList()
        every { localData.getContentList() } returns Observable.just(ArrayList())
        every { remoteData.fetchContentList() } returns Observable.just(contentList)

        repository.loadContentList()?.test()?.assertValue(contentList)

        verify(exactly = 1) { localData.insertContentList(contentList) }
    }

    @Test
    fun `when data available in db don't make the server call`() {
        val contentList = getMockContentList()
        every { localData.getContentList() } returns Observable.just(contentList)

        repository.loadContentList()?.test()?.assertValue(contentList)

        verify(exactly = 0) { remoteData.fetchContentList() }
    }

    @Test
    fun `when chain throw an error catch it`() {
        val throwable = Throwable()
        every { localData.getContentList() } returns Observable.error(throwable)

        repository.loadContentList()?.test()?.assertError(throwable)
    }

    @Test
    fun `when load and content by id fetch it from server and update db`() {
        val content = Content()
        content.id = 35
        every { remoteData.fetchContentById(35) } returns Observable.just(content)

        repository.loadContentById(35)?.test()?.assertValue(content)

        verify(exactly = 1) { remoteData.fetchContentById(35) }
        verify(exactly = 1) { localData.updateContent(content) }
    }
}