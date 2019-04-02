package com.pulse.innovation.ui.contentlist

import android.util.Log
import com.pulse.innovation.data.model.ContentListWrapper
import com.pulse.innovation.data.network.ContentApi
import com.pulse.innovation.ui.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 02.04.19.
 */
class ContentListPresenter @Inject constructor(private val contentApi: ContentApi): BasePresenter() {

    private lateinit var view: ContentListView

    fun attachView(view: ContentListView) {
        this.view = view
        loadContentList()
    }

    private fun loadContentList() {
        subscribe(contentApi.getContentList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doAfterTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveSuccess(result) },
                { error -> onRetrieveError(error) }
            ))
    }

    private fun onRetrieveError(error: Throwable?) {
        Log.d("Error", error.toString())
    }

    private fun onRetrieveSuccess(result: ContentListWrapper?) {
        view.updateList(result!!.items)
    }

    private fun onRetrieveFinish() {
        //todo
    }

    private fun onRetrieveStart() {
        //todo
    }
}