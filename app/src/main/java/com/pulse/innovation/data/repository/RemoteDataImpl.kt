package com.pulse.innovation.data.repository

import com.pulse.innovation.data.model.Content
import com.pulse.innovation.data.network.ContentApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class RemoteDataImpl @Inject constructor(private val contentApi: ContentApi) :
    RemoteData {
    override fun fetchContentList(): Observable<List<Content>> {
        return contentApi.getContentList()
            .concatMap { contentList ->
                Observable.just(contentList.items)
            }
    }
}