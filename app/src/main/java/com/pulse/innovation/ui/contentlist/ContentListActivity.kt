package com.pulse.innovation.ui.contentlist

import android.content.Intent
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.pulse.innovation.ContentApplication
import com.pulse.innovation.R
import com.pulse.innovation.data.model.Content
import com.pulse.innovation.ui.BaseActivity
import com.pulse.innovation.ui.contentdetail.ContentDetailActivity
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ContentListActivity : BaseActivity(), ContentListView, OnContentClickListener {

    private var errorSnackbar: Snackbar? = null
    private var adapter = ContentListAdapter(this)

    @Inject
    lateinit var presenter: ContentListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        ContentApplication.instance.getApplicationComponent().plusActivityComponent().inject(this)

        setAdapter()
        presenter.attachView(this)
    }

    private fun setAdapter() {
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = adapter
    }

    override fun updateList(contentList: List<Content>) {
        adapter.update(contentList)
    }

    override fun openContentDetail(contentId: Int) {
        val intentMileageCredit = Intent(this, ContentDetailActivity::class.java)
        val data = Bundle()
        data.putInt("content_id", contentId)
        intentMileageCredit.putExtras(data)
        startActivityForResult(intentMileageCredit, 1)
    }

    override fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(activityListLayout, errorMessage, Snackbar.LENGTH_SHORT)
        errorSnackbar?.show()
    }
}
