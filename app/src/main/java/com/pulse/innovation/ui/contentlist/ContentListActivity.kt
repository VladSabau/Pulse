package com.pulse.innovation.ui.contentlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pulse.innovation.ContentApplication
import com.pulse.innovation.R
import com.pulse.innovation.data.model.Content
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ContentListActivity : AppCompatActivity(), ContentListView {

    var adapter = ContentListAdapter()

    @Inject
    lateinit var presenter: ContentListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
