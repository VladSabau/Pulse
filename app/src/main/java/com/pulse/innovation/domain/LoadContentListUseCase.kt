package com.pulse.innovation.domain

import com.pulse.innovation.data.model.Content
import com.pulse.innovation.data.repository.ContentListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class LoadContentListUseCase @Inject constructor(private val repository: ContentListRepository) {
    fun loadContentList(): Observable<List<Content>>? {
        return repository.loadContentList()
    }
}