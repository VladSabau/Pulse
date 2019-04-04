package com.pulse.innovation.ui.list

import com.pulse.innovation.BaseTest
import com.pulse.innovation.domain.LoadContentUseCase
import com.pulse.innovation.ui.contentlist.ContentListPresenter
import com.pulse.innovation.ui.contentlist.ContentListView
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
class ContentListPresenterTest: BaseTest() {

    private val contentUseCase = mockk<LoadContentUseCase>(relaxed = true)
    private val view = mockk<ContentListView>(relaxed = true)

    lateinit var presenter: ContentListPresenter

    val testScheduler = TestScheduler()

    @Before
    fun before() {
        RxJavaPlugins.setComputationSchedulerHandler { testScheduler }
        presenter = ContentListPresenter(contentUseCase)
    }

    @Test
    fun `when screen loads and rx call throws error show error message`() {
        every { contentUseCase.loadContentList() } returns Observable.error(Throwable("Error"))

        presenter.attachView(view)

        verify { view.showError(any()) }
    }

    @Test
    fun `when screen loads and we have the list update the view`() {
        val contentList = getMockContentList()
        every { contentUseCase.loadContentList() } returns Observable.just(contentList)

        presenter.attachView(view)

        verify { view.showProgress(true) }
        verify { view.updateList(contentList) }
        verify { view.showProgress(false) }
    }
}