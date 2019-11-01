package com.future.scientists.classmate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class TimetableActivity : AppCompatActivity() {
    val adapter = FastItemAdapter<TimetableItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        val preferences = getSharedPreferences(PREF_TIMETABLE, Context.MODE_PRIVATE)
        val gson = Gson()

        adapter.onClickListener = { v, adapter, item, position ->
            startActivity(
                Intent(this, TimetableEditActivity::class.java).putExtra(
                    EXTRA_TIMETABLE_DATA,
                    //Тут баг не те данные передаются в тайтл время в время тайтл
                    putData(item.number, item.title, item.time, item.cabinet)
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
        val list = preferences.all
        val jsonList : MutableList<TimetableItem> = mutableListOf()
        list.forEach()
        {
            jsonList.add(gson.fromJson(it.value.toString(), TimetableItem::class.java))
        }

        adapter.setNewList(jsonList)
    }

    override fun onStart() {
        super.onStart()
        val preferences = getSharedPreferences(PREF_TIMETABLE, Context.MODE_PRIVATE)
        val gson = Gson()
        val list = preferences.all
        val jsonList : MutableList<TimetableItem> = mutableListOf()
        list.forEach()
        {
            jsonList.add(gson.fromJson(it.value.toString(), TimetableItem::class.java))
        }
        adapter.setNewList(jsonList)
    }
    fun putData(num : String,  time : String,  title : String,  cabinet : String) : Bundle
    {
        val bundle = Bundle()
        bundle.putString("number", num)
        bundle.putString("time", time)
        bundle.putString("title", title)
        bundle.putString("cabinet", cabinet)
        return bundle
    }

}
const val EXTRA_TIMETABLE_DATA = "com.future.scientists.classmate.timetable"