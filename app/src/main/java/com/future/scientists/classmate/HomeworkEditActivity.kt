package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class HomeworkEditActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_edit)
        val title = intent?.extras?.getString(EXTRA_TITLE)
        val textView = findViewById<TextView>(R.id.tvTitle)
        textView.text = title

        val actionBar = supportActionBar
        actionBar!!.title = "Домашнее задание"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(
                    Intent(this, HomeworkEditActivity2::class.java)
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

const val EXTRA_TITLE = "com.future.scientists.classmate.EXTRA_TITLE"