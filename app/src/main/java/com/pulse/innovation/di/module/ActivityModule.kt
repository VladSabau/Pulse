package com.pulse.innovation.di.module

import android.app.Activity
import com.pulse.innovation.ui.BasePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Sabau on 03.04.19.
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): BasePresenter {
        return BasePresenter()
    }
}