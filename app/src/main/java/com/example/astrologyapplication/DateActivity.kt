package com.example.astrologyapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

class DateActivity : AppCompatActivity() {

    var buttonDate: Button? = null
    var dateTextView: TextView? = null
    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        // get the references from layout file
        dateTextView = findViewById(R.id.text_view_date_1)
        buttonDate = findViewById(R.id.btnSelectDate)

        //dateTextView!!.text = "--/--/----" With UPDATEDATEINVIEW

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                //updateDateInView()
                getHoroscopeSign(monthOfYear,dayOfMonth)
            }
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        buttonDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@DateActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })
    }

    //Displays Date User Selects
    //private fun updateDateInView() {
    //val myFormat = "MM/dd/yyyy" // mention the format you need
    //val sdf = SimpleDateFormat(myFormat, Locale.US)
    //dateTextView!!.text = sdf.format(calendar.time)
    //}

    private fun getHoroscopeSign(monthOfYear: Int, dayOfMonth: Int)

    {

        if (monthOfYear == 0) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Capricorn"
            } else {
                dateTextView!!.text = "Aquarius"
            }
        } else if (monthOfYear == 1) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Aquarius"
            } else {
                dateTextView!!.text = "Pieces"
            }
        }else if (monthOfYear == 2) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Pieces"
            } else {
                dateTextView!!.text = "Aries"
            }
        }else if (monthOfYear == 3) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Aries"
            } else {
                dateTextView!!.text = "Taurus"
            }
        }else if (monthOfYear == 4) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Taurus"
            } else {
                dateTextView!!.text = "Gemini"
            }
        }else if (monthOfYear == 5) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Gemini"
            } else {
                dateTextView!!.text = "Cancer"
            }
        }else if (monthOfYear == 6) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Cancer"
            } else {
                dateTextView!!.text = "Leo"
            }
        }else if (monthOfYear == 7) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Leo"
            } else {
                dateTextView!!.text = "Virgo"
            }
        }else if (monthOfYear == 8) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Virgo"
            } else {
                dateTextView!!.text = "Libra"
            }
        }else if (monthOfYear == 9) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Libra"
            } else {
                dateTextView!!.text = "Scorpio"
            }
        }else if (monthOfYear == 10) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Scorpio"
            } else {
                dateTextView!!.text = "Sagittarius"
            }
        }else if (monthOfYear == 11) {
            if (dayOfMonth < 20) {
                dateTextView!!.text = "Sagittarius"
            } else {
                dateTextView!!.text = "Capricorn"
            }
        }
    }


}