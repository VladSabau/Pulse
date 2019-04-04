package com.pulse.innovation.ui

import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.progressbar.*

/**
 * Created by Vlad Sabau on 03.04.19.
 */
open class BaseActivity : AppCompatActivity(), BaseView {

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}