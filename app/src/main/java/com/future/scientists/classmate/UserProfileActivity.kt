package com.future.scientists.classmate

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class UserProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etSchool: EditText
    private lateinit var etClass: EditText
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        etName = findViewById(R.id.userName)
        etLastName = findViewById(R.id.userSName)
        etSchool = findViewById(R.id.userSchool)
        etClass = findViewById(R.id.userClass)

        preferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)

        if (preferences.contains(USER_ID)) {
            etName.setText(preferences.getString(USER_FIRSTNAME, ""))
            etLastName.setText(preferences.getString(USER_LASTNAME, ""))
            etSchool.setText(preferences.getString(USER_SCHOOL, ""))
            etClass.setText(preferences.getString(USER_CLASS, ""))
        } else {
            preferences.edit().putString(USER_ID, UUID.randomUUID().toString()).apply()
        }

        val button = findViewById<Button>(R.id.buttonSchedule)
        button.setOnClickListener {
            startActivity(Intent(this, TimetableActivity::class.java))
        }

        val button2 = findViewById<Button>(R.id.buttonHomework)
        button2.setOnClickListener {
            startActivity(Intent(this, HomeworksActivity::class.java))
        }
    }

    fun startHomeworks(view: View) {
        startActivity(Intent(this, HomeworksActivity::class.java))
    }

    fun save(view: View) {
        preferences.edit().putString(USER_FIRSTNAME, etName.text.toString()).apply()
        preferences.edit().putString(USER_LASTNAME, etLastName.text.toString()).apply()
        preferences.edit().putString(USER_SCHOOL, etSchool.text.toString()).apply()
        preferences.edit().putString(USER_CLASS, etClass.text.toString()).apply()
    }
}

private const val PREFS_FILE = "classmate_user"
const val USER_ID = "USER_ID"
const val USER_FIRSTNAME = "USER_FIRSTNAME"
const val USER_LASTNAME = "USER_LASTNAME"
const val USER_SCHOOL = "USER_SCHOOL"
const val USER_CLASS = "USER_CLASS"