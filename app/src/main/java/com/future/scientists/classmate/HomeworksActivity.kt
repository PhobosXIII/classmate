package com.future.scientists.classmate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import org.json.JSONObject

class HomeworksActivity : AppCompatActivity() {
    private val adapter = FastItemAdapter<HomeworkItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeworks)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter.onClickListener = { _, _, item, _ ->
            startActivity(
                Intent(this, HomeworkEditActivity::class.java).putExtra(EXTRA_ID, item.id)
            )
            true
        }

        val button = findViewById<FloatingActionButton>(R.id.add)
        button.setOnClickListener {
            startActivity(Intent(this, HomeworkEditActivity::class.java))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rvHomeworks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        val preferences = getSharedPreferences(PREFS_FILE_HOMEWORK, Context.MODE_PRIVATE)
        val homeworks = preferences.all.values.map {
            val jsonObject = JSONObject(it.toString())
            HomeworkItem(
                id = jsonObject.getString("id"),
                title = jsonObject.getString("title"),
                description = jsonObject.getString("description"),
                date = jsonObject.getString("date")
            )
        }
        adapter.setNewList(homeworks)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
