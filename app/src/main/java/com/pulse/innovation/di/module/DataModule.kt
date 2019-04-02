package com.pulse.innovation.di.module

import com.pulse.innovation.data.repository.LocalData
import com.pulse.innovation.data.repository.LocalDataImpl
import com.pulse.innovation.data.repository.RemoteData
import com.pulse.innovation.data.repository.RemoteDataImpl
import com.pulse.innovation.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

/**
 * Created by Vlad Sabau on 03.04.19.
 */
@Module
interface DataModule {

    @Binds
    @ActivityScope
    fun bindLocalData(localData: LocalDataImpl): LocalData

    @Binds
    @ActivityScope
    fun bindRemoteData(remoteData: RemoteDataImpl): RemoteData
}