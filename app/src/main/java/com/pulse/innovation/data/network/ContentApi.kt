package com.pulse.innovation.data.network

import com.pulse.innovation.data.model.ContentDetailWrapper
import com.pulse.innovation.data.model.ContentListWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Vlad Sabau on 02.04.19.
 */
interface ContentApi {

    @GET("contentList.json")
    fun getContentList(): Observable<ContentListWrapper>

    @GET("content/{id}.json")
    fun getContentDetail(@Path("id") id: Int): Observable<ContentDetailWrapper>
}