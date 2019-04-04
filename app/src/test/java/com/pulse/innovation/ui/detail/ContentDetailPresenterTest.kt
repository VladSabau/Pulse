package com.pulse.innovation.ui.detail

import com.pulse.innovation.BaseTest
import com.pulse.innovation.data.model.Content
import com.pulse.innovation.domain.LoadContentUseCase
import com.pulse.innovation.ui.contentdetail.ContentDetailPresenter
import com.pulse.innovation.ui.contentdetail.ContentDetailView
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
class ContentDetailPresenterTest: BaseTest() {

    private val contentUseCase = mockk<LoadContentUseCase>(relaxed = true)
    private val view = mockk<ContentDetailView>(relaxed = true)

    lateinit var presenter: ContentDetailPresenter

    val testScheduler = TestScheduler()

    @Before
    fun before() {
        RxJavaPlugins.setComputationSchedulerHandler { testScheduler }
        presenter = ContentDetailPresenter(contentUseCase)
    }

    @Test
    fun `when screen loads and rx call throws error show error message`() {
        every { view.getContentId() } returns 15
        every { contentUseCase.loadContentDetail(15) } returns Observable.error(Throwable("Error"))

        presenter.attachView(view)

        verify { view.showError(any()) }
    }

    @Test
    fun `when screen loads and we have the content detail update the view`() {
        val content = Content()
        every { view.getContentId() } returns 15
        every { contentUseCase.loadContentDetail(15) } returns Observable.just(content)

        presenter.attachView(view)

        verify { view.showProgress(true) }
        verify { view.updateView(content) }
        verify { view.showProgress(false) }
    }
}