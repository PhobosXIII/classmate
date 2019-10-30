package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class HomeworkEditActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_edit)
        val title = intent?.extras?.getString(EXTRA_TITLE)
        val textView = findViewById<TextView>(R.id.tvTitle)
        textView.text = title

        supportActionBar?.title = "Домашнее задание"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val datePicker = findViewById<DatePicker>(R.id.dp)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
           val msg = "${datePicker.dayOfMonth}.${datePicker.month}.${datePicker.year}"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }
}

const val EXTRA_TITLE = "com.future.scientists.classmate.EXTRA_TITLE"