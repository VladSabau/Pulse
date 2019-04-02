package com.pulse.innovation.data.repository

import com.pulse.innovation.data.model.Content
import io.reactivex.Observable

/**
 * Created by Vlad Sabau on 03.04.19.
 */
interface RemoteData {
    fun fetchContentList(): Observable<List<Content>>
}
