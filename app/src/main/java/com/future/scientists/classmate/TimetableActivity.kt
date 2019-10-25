package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class TimetableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
        val adapter = FastItemAdapter<TimetableItem>()

        val recyclerView = findViewById<RecyclerView>(R.id.timetable)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        val timetable = listOf(
            TimetableItem("1.","Подг. русский","8:15-8:55","305"),
            TimetableItem("2.","Физ-ра","9:05-9:45","-"),
            TimetableItem("3.","География","10:00-10:40","304"),
            TimetableItem("4.","Физика","10:55-11:35","202"),
            TimetableItem("5.","История","11:45-12:25","107")
        )
        adapter.setNewList(timetable)
    }
}
