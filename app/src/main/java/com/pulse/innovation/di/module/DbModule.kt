package com.pulse.innovation.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.pulse.innovation.data.database.AppDatabase
import com.pulse.innovation.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Sabau on 02.04.19.
 */
@Module
@Suppress("unused")
class DbModule {

    @Provides
    @ApplicationScope
    fun provideContentDb(application: Application) =
        Room.databaseBuilder(
            application,
            AppDatabase::class.java, "db-content"
        ).build()

    @Provides
    @ApplicationScope
    fun provideContentDao(appDatabase: AppDatabase) = appDatabase.contentDao()
}