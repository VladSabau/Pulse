package com.pulse.innovation.ui

import com.pulse.innovation.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vlad Sabau on 02.04.19.
 */
open class BasePresenter {
    private val subscriptions = CompositeDisposable()

    protected val schedulerProvider = SchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread())

    fun subscribe(subscription: Disposable) {
        subscriptions.add(subscription)
    }

    fun unsubscribe() {
        subscriptions.dispose()
    }
}