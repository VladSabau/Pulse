package com.pulse.innovation

import android.app.Application
import com.pulse.innovation.di.component.ApplicationComponent
import com.pulse.innovation.di.component.DaggerApplicationComponent

/**
 * Created by Vlad Sabau on 02.04.19.
 */
class ContentApplication : Application() {
    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: ContentApplication
            private set
    }

    fun getApplicationComponent(): ApplicationComponent = appComponent
}