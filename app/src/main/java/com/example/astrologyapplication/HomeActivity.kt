package com.example.astrologyapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    private lateinit var moonImageView: ImageView
    private lateinit var appTitleView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var findSignButton: Button
    private lateinit var alreadyKnowSignTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        moonImageView = findViewById(R.id.img_night_calls)
        appTitleView = findViewById(R.id.txtPolyPrediction)
        descriptionTextView = findViewById(R.id.txtDescription)
        findSignButton = findViewById(R.id.btnFindMySign)
        alreadyKnowSignTextView = findViewById(R.id.txtalready_know)
    }

    fun openSignActivity(view: View)
    {
        val intent = Intent(this@HomeActivity, MainActivity::class.java)
        startActivity(intent)
    }

    //    fun openDateActivity(view: View)
    //    {
    //        val intent = Intent(this@DateActivity, MainActivity::class.java)
    //        startActivity(intent)
    //    }
    // Make a new Date Activity to replace MainActivity so user can find their Horoscope
    //
}