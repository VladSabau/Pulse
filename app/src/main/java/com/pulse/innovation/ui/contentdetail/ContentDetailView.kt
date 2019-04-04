package com.pulse.innovation.ui.contentdetail

import com.pulse.innovation.data.model.Content
import com.pulse.innovation.ui.BaseView

/**
 * Created by Vlad Sabau on 03.04.19.
 */
interface ContentDetailView : BaseView {
    fun updateView(content: Content)

    fun getContentId(): Int
}