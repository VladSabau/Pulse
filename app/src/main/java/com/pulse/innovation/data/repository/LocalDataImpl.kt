package com.pulse.innovation.data.repository

import com.pulse.innovation.data.database.ContentsDao
import com.pulse.innovation.data.model.Content
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class LocalDataImpl @Inject constructor(private val contentsDao: ContentsDao) :
    LocalData {

    override fun getContentList(): Observable<List<Content>> {
        return Observable.fromCallable { contentsDao.all }
    }

    override fun insertContentList(contentList: List<Content>) {
        contentsDao.insertAll(contentList)
    }
}