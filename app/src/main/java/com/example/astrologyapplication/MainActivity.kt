package com.example.astrologyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Horoscope>

    lateinit var imageId : Array<Int>
    lateinit var horoscopeName : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Choose Your Sign"

        imageId = arrayOf(
            R.drawable.aries,
            R.drawable.taurus,
            R.drawable.gemini,
            R.drawable.cancer,
            R.drawable.leo,
            R.drawable.virgo,
            R.drawable.libra,
            R.drawable.scorpio,
            R.drawable.sagittarius,
            R.drawable.capricorn,
            R.drawable.aquarius,
            R.drawable.pisces
        )

        horoscopeName = arrayOf(
            "Aries",
            "Taurus",
            "Gemini",
            "Cancer",
            "Leo",
            "Virgo",
            "Libra",
            "Scorpio",
            "Sagittarius",
            "Capricorn",
            "Aquarius",
            "Pisces",
        )

        newRecyclerView  = findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Horoscope>()
        getUserDate()
    }

    private fun getUserDate()
    {
        for (i in imageId.indices){

            val horoscopes = Horoscope(imageId[i], horoscopeName[i])
            newArrayList.add(horoscopes)
        }

        var adapter = HoroscopeAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : HoroscopeAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText(this@MainActivity,"you clicked on item no. $position", Toast.LENGTH_SHORT).show()
            }

        })
    }

}
