package com.pulse.innovation.ui.contentlist

import com.pulse.innovation.R
import com.pulse.innovation.data.model.Content
import com.pulse.innovation.domain.LoadContentUseCase
import com.pulse.innovation.ui.BasePresenter
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 02.04.19.
 */
class ContentListPresenter @Inject constructor(private val contentUseCase: LoadContentUseCase): BasePresenter() {

    private lateinit var view: ContentListView

    fun attachView(view: ContentListView) {
        this.view = view
        loadContentList()
    }

    private fun loadContentList() {
        subscribe(contentUseCase.loadContentList()
            ?.compose(schedulerProvider.getSchedulersForObservable())
            ?.doOnSubscribe { onRetrieveStart() }
            ?.doAfterTerminate { onRetrieveFinish() }
            ?.subscribe(
                { result -> onRetrieveSuccess(result) },
                { error -> onRetrieveError(error) }
            )!!)
    }

    private fun onRetrieveError(error: Throwable?) {
        view.showError(R.string.load_content_list_error)
    }

    private fun onRetrieveSuccess(result: List<Content>?) {
        view.updateList(result!!)
    }

    private fun onRetrieveFinish() {
        view.showProgress(false)
    }

    private fun onRetrieveStart() {
        view.showProgress(true)
    }
}