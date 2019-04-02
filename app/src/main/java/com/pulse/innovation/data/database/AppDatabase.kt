package com.pulse.innovation.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pulse.innovation.data.model.Content

/**
 * Created by Vlad Sabau on 02.04.19.
 */
@Database(entities = [Content::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contentDao(): ContentsDao
}