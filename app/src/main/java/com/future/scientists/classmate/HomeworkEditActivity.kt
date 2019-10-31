package com.future.scientists.classmate

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.widget.*

class HomeworkEditActivity : AppCompatActivity(){

    private lateinit var tvTitle: EditText
    private lateinit var tvDesc: EditText
    private lateinit var dp: DatePicker
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_edit)
        val title = intent?.extras?.getString(EXTRA_TITLE)
        val textView = findViewById<TextView>(R.id.tvTitle)
        textView.text = title

        preferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //val datePicker = findViewById<DatePicker>(R.id.dp)
        val button = findViewById<Button>(R.id.button)
         button.setOnClickListener {
             preferences.edit().putString(HOMEWORK_TITLE, tvTitle.text.toString()).apply()
             preferences.edit().putString(HOMEWORK_DESCRIPTION, tvDesc.text.toString()).apply()
             preferences.edit().putString(HOMEWORK_DATEPICKER, "${dp.dayOfMonth}, ${dp.month}, ${dp.year}").apply()
             finish()
        }
    }

    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }
}

const val EXTRA_TITLE = "com.future.scientists.classmate.EXTRA_TITLE"
const val HOMEWORK_TITLE = "HOMEWORK_TITLE"
const val HOMEWORK_DESCRIPTION = "HOMEWORK_DESCRIPTION"
const val HOMEWORK_DATEPICKER = "HOMEWORK_DATEPICKER"