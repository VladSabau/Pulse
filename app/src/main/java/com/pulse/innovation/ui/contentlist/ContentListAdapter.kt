package com.pulse.innovation.ui.contentlist

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.pulse.innovation.R
import com.pulse.innovation.data.model.Content

/**
 * Created by Vlad Sabau on 02.04.19.
 */
class ContentListAdapter: RecyclerView.Adapter<ContentListAdapter.ListViewHolder>() {

    private var contentList: ArrayList<Content> = ArrayList()

    //todo private val listener: ContentListAdapter.onContentClickListener

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val content = contentList[position]

        // holder!!.bind(post)
        holder.title!!.text = content.title
        holder.subtitle!!.text = content.subtitle
        holder.date!!.text = content.date

        holder.layout!!.setOnClickListener {
            //todo listener.openContentDetail(content.id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.content_item_list, parent, false)
        return ListViewHolder(itemView)
    }

    fun update(contentList: List<Content>) {
        this.contentList.addAll(contentList)
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView.findViewById<ConstraintLayout>(R.id.content_item)
        val title = itemView.findViewById<TextView>(R.id.content_title)
        val subtitle = itemView.findViewById<TextView>(R.id.content_subtitle)
        val date = itemView.findViewById<TextView>(R.id.content_date)
    }

    interface onContentClickListener {
        fun openContentDetail(contentId : Int)
    }

}