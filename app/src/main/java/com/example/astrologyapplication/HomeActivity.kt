package com.example.astrologyapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

    }

    fun openSignActivity(view: View) {
        val intent = Intent(this@HomeActivity, DateActivity::class.java)
        startActivity(intent)
    }

    fun openDateActivity(view: View) {
        val intent = Intent(this@HomeActivity, MainActivity::class.java)
        startActivity(intent)
    }


}