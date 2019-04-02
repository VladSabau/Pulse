package com.pulse.innovation.ui.contentlist

import com.pulse.innovation.data.model.Content

/**
 * Created by Vlad Sabau on 02.04.19.
 */
interface ContentListView {
    fun updateList(contentList: List<Content>)
}