package com.pulse.innovation.data.repository

import com.pulse.innovation.data.model.Content
import io.reactivex.Observable

/**
 * Created by Vlad Sabau on 03.04.19.
 */
interface LocalData {
    fun getContentList(): Observable<List<Content>>

    fun insertContentList(contentList: List<Content>)
}
