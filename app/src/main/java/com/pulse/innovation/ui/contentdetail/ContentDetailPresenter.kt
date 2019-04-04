package com.pulse.innovation.ui.contentdetail

import com.pulse.innovation.R
import com.pulse.innovation.data.model.Content
import com.pulse.innovation.domain.LoadContentUseCase
import com.pulse.innovation.ui.BasePresenter
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class ContentDetailPresenter @Inject constructor(private val contentUseCase: LoadContentUseCase): BasePresenter() {

    private lateinit var view: ContentDetailView

    fun attachView(view: ContentDetailView) {
        this.view = view
        loadContentList()
    }

    private fun loadContentList() {
        subscribe(contentUseCase.loadContentDetail(view.getContentId())
            ?.compose(schedulerProvider.getSchedulersForObservable())
            ?.doOnSubscribe { onRetrieveStart() }
            ?.doAfterTerminate { onRetrieveFinish() }
            ?.subscribe(
                { result -> onRetrieveSuccess(result) },
                { error -> onRetrieveError(error) }
            )!!)
    }

    private fun onRetrieveError(error: Throwable?) {
        view.showError(R.string.load_content_by_id_failed)
    }

    private fun onRetrieveSuccess(content: Content?) {
        view.updateView(content!!)
    }

    private fun onRetrieveFinish() {
        view.showProgress(false)
    }

    private fun onRetrieveStart() {
        view.showProgress(true)
    }
}