package com.future.scientists.classmate

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import java.util.*


class TimetableEditActivity : AppCompatActivity() {

    public final val EXTRA = "com.future.scientists.classmate.TimetableEditActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_edit)

        val sharedPrefences = getSharedPreferences(PREF_TIMETABLE, Context.MODE_PRIVATE);
        val editor = sharedPrefences.edit();
        val gson = Gson()
        val bundle = intent?.extras?.getBundle(EXTRA_TIMETABLE_DATA)
        val number = bundle?.getString("number")
        val time = bundle?.getString("time")
        val title  = bundle?.getString("title")
        val cabinet = bundle?.getString("cabinet")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val edNumber = findViewById<TextInputEditText>(R.id.edNumber)
        val edTime = findViewById<TextInputEditText>(R.id.edTime)
        val edTitle = findViewById<TextInputEditText>(R.id.edTitle)
        val edCabinet = findViewById<TextInputEditText>(R.id.edCabinet)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        edNumber.setText(number)
        edTitle.setText(title)
        edTime.setText(time)
        edCabinet.setText(cabinet)
        btnSave.setOnClickListener(View.OnClickListener {
            val uid = UUID.randomUUID()
            val number = edNumber.text.toString()
            val time = edTime.text.toString()
            val title = edTitle.text.toString()
            val cabinet = edCabinet.text.toString()
            val jsonTimetable = gson.toJson(TimetableItem(number, time,title, cabinet))
            editor.putString(uid.toString(), jsonTimetable)
            editor.apply()
            finish()
        })
    }
    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }
}
const val PREF_TIMETABLE : String = "timetable"

