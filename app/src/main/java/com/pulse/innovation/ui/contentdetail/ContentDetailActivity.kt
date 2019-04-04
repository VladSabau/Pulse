package com.pulse.innovation.ui.contentdetail

import android.os.Bundle
import com.pulse.innovation.ContentApplication
import com.pulse.innovation.R
import com.pulse.innovation.data.model.Content
import com.pulse.innovation.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 03.04.19.
 */
class ContentDetailActivity : BaseActivity(), ContentDetailView {

    @Inject
    lateinit var presenter: ContentDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ContentApplication.instance.getApplicationComponent().plusActivityComponent().inject(this)

        presenter.attachView(this)
    }

    override fun updateView(content: Content) {
        detail_title.text = content.title
        detail_subtitle.text = content.subtitle
        detail_body.text = content.body
        detail_date.text = content.date
    }

    override fun getContentId(): Int {
        val extras = intent.extras
        return if (extras != null && extras.containsKey("content_id")) {
            extras.getInt("content_id")
        } else 0
    }
}
