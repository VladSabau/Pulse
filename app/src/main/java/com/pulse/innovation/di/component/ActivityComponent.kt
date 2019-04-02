package com.pulse.innovation.di.component

import com.pulse.innovation.di.module.ActivityModule
import com.pulse.innovation.di.scope.ActivityScope
import com.pulse.innovation.ui.contentlist.ContentListActivity
import dagger.Subcomponent

/**
 * Created by Vlad Sabau on 02.04.19.
 */
@Subcomponent(modules = [ActivityModule::class])
@ActivityScope
interface ActivityComponent {
    fun inject(activity: ContentListActivity)
}