package com.pulse.innovation.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Vlad Sabau on 02.04.19.
 */
data class ContentDetailWrapper(
    @SerializedName("item") var item: Content = Content()
)