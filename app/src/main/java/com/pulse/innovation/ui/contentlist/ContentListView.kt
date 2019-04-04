package com.pulse.innovation.ui.contentlist

import android.support.annotation.StringRes
import com.pulse.innovation.data.model.Content
import com.pulse.innovation.ui.BaseView

/**
 * Created by Vlad Sabau on 02.04.19.
 */
interface ContentListView : BaseView {
    fun updateList(contentList: List<Content>)

    fun showError(@StringRes errorMessage: Int)
}