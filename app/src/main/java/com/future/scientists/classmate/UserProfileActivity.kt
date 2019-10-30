package com.future.scientists.classmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
//        getSharedPreferences()
    }

    fun startHomeworks(view: View) {
        startActivity(Intent(this, HomeworksActivity::class.java))
    }
}
