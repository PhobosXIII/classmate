package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = FastItemAdapter<HomeworkItem>()
        adapter.onClickListener = { v, adapter, item, position ->
            startActivity(
                Intent(this, HomeworkEditActivity::class.java).putExtra(
                    EXTRA_TITLE,
                    item.title
                )
            )
            true
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rvHomeworks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        val homeworks = listOf(
            HomeworkItem("History", "Create text about Caesar."),
            HomeworkItem("English", "Anything"),
            HomeworkItem("Maths", "2+2=4"),
            HomeworkItem("Biology", "Read about T-Rex"),
            HomeworkItem("History", "Create text about Caesar."),
            HomeworkItem("English", "Anything"),
            HomeworkItem("Maths", "2+2=4"),
            HomeworkItem("Biology", "Read about T-Rex"),
            HomeworkItem("History", "Create text about Caesar."),
            HomeworkItem("English", "Anything"),
            HomeworkItem("Maths", "2+2=4"),
            HomeworkItem("Biology", "Read about T-Rex")
        )
        adapter.setNewList(homeworks)
    }
}
