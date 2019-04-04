package com.pulse.innovation.di.component

import com.pulse.innovation.di.module.ActivityModule
import com.pulse.innovation.di.module.DataModule
import com.pulse.innovation.di.module.DomainModule
import com.pulse.innovation.di.scope.ActivityScope
import com.pulse.innovation.ui.contentdetail.ContentDetailActivity
import com.pulse.innovation.ui.contentlist.ContentListActivity
import dagger.Subcomponent

/**
 * Created by Vlad Sabau on 02.04.19.
 */
@Subcomponent(modules = [ActivityModule::class, DataModule::class, DomainModule::class])
@ActivityScope
interface ActivityComponent {
    fun inject(activity: ContentListActivity)

    fun inject(activity: ContentDetailActivity)
}