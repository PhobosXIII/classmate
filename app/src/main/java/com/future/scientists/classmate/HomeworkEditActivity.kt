package com.future.scientists.classmate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeworkEditActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_edit)
        val title = intent?.extras?.getString(EXTRA_TITLE)
        val textView = findViewById<TextView>(R.id.tvTitle)
        textView.text = title
    }
}

const val EXTRA_TITLE = "com.future.scientists.classmate.EXTRA_TITLE"