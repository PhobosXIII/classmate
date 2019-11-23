package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class TimetableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val adapter = FastItemAdapter<TimetableItem>()
        adapter.onClickListener = { v, adapter, item, position ->
            startActivity(
                Intent(this, TimetableEditActivity::class.java).putExtra(
                    EXTRA_TITLE,
                    item.title
                )
            )
            true
        }

        val button = findViewById<FloatingActionButton>(R.id.add)
        button.setOnClickListener {
            startActivity(Intent(this, TimetableEditActivity::class.java))
        }

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

    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }
}

const val EXTRA_TITLE = "EXTRA_TITLE"