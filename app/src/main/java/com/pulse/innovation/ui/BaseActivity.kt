package com.pulse.innovation.ui

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_list.*

/**
 * Created by Vlad Sabau on 03.04.19.
 */
open class BaseActivity : AppCompatActivity(), BaseView {

    private var errorSnackbar: Snackbar? = null

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(activityLayout, errorMessage, Snackbar.LENGTH_SHORT)
        errorSnackbar?.show()
    }
}