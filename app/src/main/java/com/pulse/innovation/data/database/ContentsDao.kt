package com.pulse.innovation.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.pulse.innovation.data.model.Content

/**
 * Created by Vlad Sabau on 02.04.19.
 */
@Dao
interface ContentsDao {
    @get:Query("SELECT * FROM content ORDER BY id DESC")
    val all: List<Content>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(contents: List<Content>)
}