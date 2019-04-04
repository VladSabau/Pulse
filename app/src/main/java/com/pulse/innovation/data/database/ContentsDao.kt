package com.pulse.innovation.data.database

import android.arch.persistence.room.*
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

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(content: Content)

    @Query("SELECT * FROM content WHERE id = :contentId ORDER BY id DESC")
    fun getContentById(contentId: Int): Content

}