package com.future.scientists.classmate

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class TimetableItem(val number: String, val title: String, val time: String, val cabinet: String) : AbstractItem<TimetableItem.ViewHolder>(){
    override val layoutRes: Int
        get() = R.layout.item_timetable

    override val type: Int
        get() = R.id.timetable

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<TimetableItem>(view){
        private val number = itemView.findViewById<TextView>(R.id.number)
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val time = itemView.findViewById<TextView>(R.id.time)
        private val cabinet = itemView.findViewById<TextView>(R.id.cabinet)

        override fun bindView(item: TimetableItem, payloads: MutableList<Any>) {
            number.text = item.number
            title.text = item.title
            time.text = item.time
            cabinet.text = item.cabinet
        }

        override fun unbindView(item: TimetableItem) {
            number.text = null
            title.text = null
            time.text = null
            cabinet.text = null
        }

    }
}