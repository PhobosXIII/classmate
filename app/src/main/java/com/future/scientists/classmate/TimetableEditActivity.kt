package com.future.scientists.classmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText


class TimetableEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_edit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val edNumber = findViewById<TextInputEditText>(R.id.edNumber)
        val edTime = findViewById<TextInputEditText>(R.id.edTime)
        val edTitle = findViewById<TextInputEditText>(R.id.edTitle)
        val edCabinet = findViewById<TextInputEditText>(R.id.edCabinet)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)



    }
}
