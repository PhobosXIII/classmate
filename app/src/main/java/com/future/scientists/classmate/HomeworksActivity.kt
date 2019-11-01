package com.future.scientists.classmate

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.mikepenz.fastadapter.adapters.FastItemAdapter


class HomeworksActivity : AppCompatActivity() {
    val adapter = FastItemAdapter<HomeworkItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeworks)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val preferences = getSharedPreferences(PREF_HOMEWORKS, MODE_PRIVATE)
        val gson = Gson()

        adapter.onClickListener = { v, adapter, item, position ->
            startActivity(
                Intent(this, HomeworkEditActivity::class.java).putExtra(
                    EXTRA_HOMEWORK_DATA,
                    putData(item.title, item.description, item.data)
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

       /* val homeworks = listOf<HomeworkItem>(
            HomeworkItem(" ", "Русский язык", "Упражнение 14, стр. 7", "30 Октября"),
            HomeworkItem(" ", "Литература", "Изучить биографию А.С.Пушкина", "30 Октября"),
            HomeworkItem(" ", "Алгебра", "№ 3.11 - 3.19", "30 Октября"),
            HomeworkItem(" ", "Геометрия", "Выучить теорему Пифагора", "30 Октября"),
            HomeworkItem(" ", "Английский язык", "Выучить слова. Ex 9, p.5", "30 Октября"),
            HomeworkItem(" ", "История", "Сделать таблицу о Наполеоне", "30 Октября")
        )*/
        val list = preferences.all
        Log.d("HomeworksActivity", list.values.toString())
        val jsonList : MutableList<HomeworkItem>  = mutableListOf()
        list.forEach()
        {
            jsonList.add(gson.fromJson(it.value.toString(), HomeworkItem::class.java))
        }
        adapter.setNewList(jsonList)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        val preferences = getSharedPreferences(PREF_HOMEWORKS, MODE_PRIVATE)
        val gson = Gson()
        val list = preferences.all
        val jsonList : MutableList<HomeworkItem>  = mutableListOf()
        list.forEach()
        {
            jsonList.add(gson.fromJson(it.value.toString(), HomeworkItem::class.java))
        }
        adapter.setNewList(jsonList)
    }
    public fun putData(title : String, desc : String, date : String) : Bundle
    {
        val bundle = Bundle()
        bundle.putString("title", title)
        bundle.putString("desc", desc)
        bundle.putString("date", date)
        return bundle
    }
}
const val EXTRA_HOMEWORK_DATA = "com.future.scientists.classmate.homeworks"
