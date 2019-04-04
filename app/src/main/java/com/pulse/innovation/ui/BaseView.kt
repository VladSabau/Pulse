package com.pulse.innovation.ui

import android.support.annotation.StringRes

/**
 * Created by Vlad Sabau on 03.04.19.
 */
interface BaseView {
    fun showProgress(show: Boolean)

    fun showError(@StringRes errorMessage: Int)
}