package com.pulse.innovation.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vlad Sabau on 02.04.19.
 */
data class ContentListWrapper(
    @SerializedName("items") var items: List<Content> = ArrayList()
)