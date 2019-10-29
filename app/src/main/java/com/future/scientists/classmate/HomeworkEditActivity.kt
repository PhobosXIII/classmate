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

        supportActionBar?.title = "Домашнее задание"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this, HomeworksActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra(
                    EXTRA_TITLE,
                    true
            ))
            finish()
        }


    }

    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }
}

const val EXTRA_TITLE = "com.future.scientists.classmate.EXTRA_TITLE"