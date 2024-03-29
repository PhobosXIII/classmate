package com.future.scientists.classmate

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class HomeworkItem(
    val id: String,
    val title: String,
    val description: String,
    val date: String
) : AbstractItem<HomeworkItem.ViewHolder>() {
    override val layoutRes: Int
        get() = R.layout.item_homework

    override val type: Int
        get() = R.id.homework

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<HomeworkItem>(view) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        private val date = itemView.findViewById<TextView>(R.id.data)

        override fun bindView(item: HomeworkItem, payloads: MutableList<Any>) {
            tvTitle.text = item.title
            tvDescription.text = item.description
            date.text = item.date
        }

        override fun unbindView(item: HomeworkItem) {
            tvTitle.text = null
            tvDescription.text = null
            date.text = null
        }

    }
}