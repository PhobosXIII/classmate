package com.future.scientists.classmate

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.util.*

class HomeworkEditActivity : AppCompatActivity() {

    private var id: String? = null
    private lateinit var tvTitle: EditText
    private lateinit var tvDesc: EditText
    private lateinit var dp: DatePicker
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_edit)

        tvTitle = findViewById(R.id.tvTitle)
        tvDesc = findViewById(R.id.tvDesc)
        dp = findViewById(R.id.dp)

        preferences = getSharedPreferences(PREFS_FILE_HOMEWORK, Context.MODE_PRIVATE)
        id = intent?.extras?.getString(EXTRA_ID)
        preferences.getString(id, null)?.let {
            val jsonObject = JSONObject(it)
            tvTitle.setText(jsonObject.getString("title"))
            tvDesc.setText(jsonObject.getString("description"))
            val date = jsonObject.getString("date").split(", ")
            dp.updateDate(date[2].toInt(), date[1].toInt(), date[0].toInt())
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            if (id === null) id = UUID.randomUUID().toString()
            val json = JSONObject()
                .put("id", id)
                .put("title", tvTitle.text.toString())
                .put("description", tvDesc.text.toString())
                .put("date", "${dp.dayOfMonth}, ${dp.month}, ${dp.year}")
                .toString()

            preferences.edit().putString(id, json).apply()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

const val PREFS_FILE_HOMEWORK = "classmate_homework"
const val EXTRA_ID = "com.future.scientists.classmate.EXTRA_ID"