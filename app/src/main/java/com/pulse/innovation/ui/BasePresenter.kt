package com.pulse.innovation.ui

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Vlad Sabau on 02.04.19.
 */
open class BasePresenter {
    private val subscriptions = CompositeDisposable()

    fun subscribe(subscription: Disposable) {
        subscriptions.add(subscription)
    }

    fun unsubscribe() {
        subscriptions.dispose()
    }
}