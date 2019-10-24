package com.future.scientists.classmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeworkEditActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_edit2)



        val actionBar2 = supportActionBar
        actionBar2!!.title = "Домашнее задание 2"
        actionBar2.setDisplayHomeAsUpEnabled(true)
        actionBar2.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}