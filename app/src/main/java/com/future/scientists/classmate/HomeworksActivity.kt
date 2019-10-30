package com.future.scientists.classmate

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import retrofit2.Retrofit
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class HomeworksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeworks)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = FastItemAdapter<HomeworkItem>()
        adapter.onClickListener = { v, adapter, item, position ->
            startActivity(
                Intent(this, HomeworkEditActivity::class.java).putExtra(
                    EXTRA_TITLE,
                    item.title
                )
            )
            true
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rvHomeworks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("http://w96076ih.beget.tech/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<ClassmateService>(ClassmateService::class.java)
        service.saveUser(User(UUID.randomUUID().toString(), "I", "R", "L", "123", "10"))
                .enqueue(object : Callback<User> {
                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Log.e("ConnectionError", "", t)
                    }

                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        val savedUser = response.body()
                        Log.d("HomeworksActivity", ""+response.code())
                        val homeworks = listOf(
                            HomeworkItem("History", savedUser?.schoolClass ?: "nothing"),
                            HomeworkItem("English", "Anything"),
                            HomeworkItem("Maths", "2+2=4"),
                            HomeworkItem("Biology", "Read about T-Rex"),
                            HomeworkItem("History", "Create text about Caesar."),
                            HomeworkItem("English", "Anything"),
                            HomeworkItem("Maths", "2+2=4"),
                            HomeworkItem("Biology", "Read about T-Rex"),
                            HomeworkItem("History", "Create text about Caesar."),
                            HomeworkItem("English", "Anything"),
                            HomeworkItem("Maths", "2+2=4"),
                            HomeworkItem("Biology", "Read about T-Rex")
                        )
                        adapter.setNewList(homeworks)
                    }

                })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
