package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import java.util.*

class HomeworkEditActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_edit)
        val preferences = getSharedPreferences(PREF_HOMEWORKS, MODE_PRIVATE)
        val gson = Gson()
        val editor = preferences.edit()
        val bundle = intent?.extras?.getBundle(EXTRA_HOMEWORK_DATA)


        // EditText почему то textView
        val textView = findViewById<TextView>(R.id.tvTitle)
        val edDesc = findViewById<EditText>(R.id.tvDesc)
        textView.setText(bundle?.getString("title"))
        edDesc.setText(bundle?.getString("desc"))


        supportActionBar?.title = "Домашнее задание"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val datePicker = findViewById<DatePicker>(R.id.dp)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
           val msg = "${datePicker.dayOfMonth}.${datePicker.month}.${datePicker.year}"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            val uid = UUID.randomUUID()
            // Id 0 он не используется
            editor.putString(uid.toString(), gson.toJson(HomeworkItem("0", textView.text.toString(), edDesc.text.toString(), msg)))
            editor.apply()
            finish()
        }
    }

    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }
}

const val EXTRA_TITLE = "com.future.scientists.classmate.EXTRA_TITLE"
const val PREF_HOMEWORKS = "homeworks"