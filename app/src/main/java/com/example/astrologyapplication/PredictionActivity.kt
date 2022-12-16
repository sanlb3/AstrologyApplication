package com.example.astrologyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PredictionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction)

        val signImg: ImageView = findViewById(R.id.image_sign)
        val signName: TextView = findViewById(R.id.title_sign)
        val predictions: TextView = findViewById(R.id.prediction_text)

        val bundle : Bundle? = intent.extras
        val sign = bundle!!.getString("sign")
        val imageId = bundle.getInt("imageId")
        val prediction = bundle.getString("prediction")

        signImg.setImageResource(imageId)
        signName.text = sign
        predictions.text = prediction

    }
}
