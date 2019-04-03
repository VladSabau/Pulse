package com.pulse.innovation.util

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class SchedulerProvider(val backgroundScheduler: Scheduler, val foregroundScheduler: Scheduler) {

    fun <T> getSchedulersForObservable(): (Observable<T>) -> Observable<T> {
        return { observable: Observable<T> ->
            observable.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

    fun <T> getSchedulersForSingle(): (Single<T>) -> Single<T> {
        return { single: Single<T> ->
            single.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }
}