package com.pulse.innovation.di.module

import com.pulse.innovation.data.repository.ContentRepository
import com.pulse.innovation.data.repository.ContentRepositoryImpl
import com.pulse.innovation.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

/**
* Created by Vlad Sabau on 03.04.19.
*/
@Module
interface DomainModule {

    @Binds
    @ActivityScope
    fun bindRepository(contentRepositoryImpl: ContentRepositoryImpl): ContentRepository
}