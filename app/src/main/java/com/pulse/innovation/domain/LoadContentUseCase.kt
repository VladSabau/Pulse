package com.pulse.innovation.domain

import com.pulse.innovation.data.model.Content
import com.pulse.innovation.data.repository.ContentRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class LoadContentUseCase @Inject constructor(private val repository: ContentRepository) {
    fun loadContentList(): Observable<List<Content>>? {
        return repository.loadContentList()
    }

    fun loadContentDetail(contentId: Int): Observable<Content>? {
        return repository.loadContentById(contentId)
    }
}