package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class HomeworksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeworks)
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

        val button = findViewById<FloatingActionButton>(R.id.edit)
        button.setOnClickListener {
            startActivity(Intent(this, HomeworkEditActivity::class.java))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rvHomeworks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        val homeworks = listOf<HomeworkItem>(
            HomeworkItem(" ", "Русский язык", "Упражнение 14, стр. 7", "30 Октября"),
            HomeworkItem(" ", "Литература", "Изучить биографию А.С.Пушкина", "30 Октября"),
            HomeworkItem(" ", "Алгебра", "№ 3.11 - 3.19", "30 Октября"),
            HomeworkItem(" ", "Геометрия", "Выучить теорему Пифагора", "30 Октября"),
            HomeworkItem(" ", "Английский язык", "Выучить слова. Ex 9, p.5", "30 Октября"),
            HomeworkItem(" ", "История", "Сделать таблицу о Наполеоне", "30 Октября")
        )
        adapter.setNewList(homeworks)
    }
}
