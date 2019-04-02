package com.pulse.innovation.data.model

import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Vlad Sabau on 02.04.19.
 */
data class ContentDetail (
    @SerializedName("id") @PrimaryKey var id: Int = 0,
    @SerializedName("title") var title: String = "",
    @SerializedName("subtitle") var subtitle: String = "",
    @SerializedName("body") var body: String = "",
    @SerializedName("date") var date: String = ""
)