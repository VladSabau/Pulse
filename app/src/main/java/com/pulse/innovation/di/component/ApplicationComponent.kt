package com.pulse.innovation.di.component

import android.app.Application
import com.pulse.innovation.di.module.DbModule
import com.pulse.innovation.di.module.NetworkModule
import com.pulse.innovation.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Vlad Sabau on 02.04.19.
 */
@Component(modules = [DbModule::class, NetworkModule::class])
@ApplicationScope
interface ApplicationComponent{
    fun plusActivityComponent() : ActivityComponent

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        @BindsInstance
        fun application(application: Application): Builder
    }

}