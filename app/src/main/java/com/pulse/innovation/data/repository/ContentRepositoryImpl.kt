package com.pulse.innovation.data.repository

import com.pulse.innovation.data.model.Content
import io.reactivex.Observable
import io.reactivex.functions.Predicate
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class ContentRepositoryImpl @Inject constructor(private val localData: LocalData,
                                                private val remoteData: RemoteData
): ContentRepository {

    override fun loadContentList(): Observable<List<Content>>? {
        return getContentValid()
    }

    private fun getContentValid(): Observable<List<Content>>? {
        return localData.getContentList()
            .filter(Predicate { list -> !list.isEmpty() })
            .switchIfEmpty(fetchContentList())
    }

    private fun fetchContentList(): Observable<List<Content>>? {
        return remoteData.fetchContentList()
            .concatMap { contentList ->
                localData.insertContentList(contentList)
                Observable.just(contentList)
            }
    }

    override fun loadContentById(contentId: Int): Observable<Content>? {
        return fetchContentById(contentId)
    }

    private fun fetchContentById(contentId: Int): Observable<Content>? {
        return remoteData.fetchContentById(contentId)
            .concatMap { content ->
                localData.updateContent(content)
                Observable.just(content)
            }
    }
}