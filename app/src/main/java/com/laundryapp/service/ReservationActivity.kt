package com.laundryapp.service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.laundryapp.MainActivity
import com.laundryapp.R

class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val reservationId=intent.getLongExtra(MainActivity.RESERVATIONID_PARAM,0)
        val reservationUser=intent.getStringExtra(MainActivity.RESERVATIONUSER_PARAM)
        val reservationDate=intent.getStringExtra(MainActivity.RESERVATIONDATE_PARAM)
        val reservationStartTime=intent.getStringExtra(MainActivity.RESERVATIONSTARTTIME_PARAM)
        val reservationEndTime=intent.getStringExtra(MainActivity.RESERVATIONENDTIME_PARAM)
        val reservationAvailable=intent.getBooleanExtra(MainActivity.RESERVATIONAVAILABLE_PARAM, true)


        val idValue = findViewById<TextView>(R.id.txt_reservation_id)
        idValue.text = reservationId.toString()

        val userValue = findViewById<TextView>(R.id.txt_reservation_user)
        userValue.text = reservationUser

        val reservationDatevalue = findViewById<TextView>(R.id.txt_reservation_date)
        reservationDatevalue.text = reservationDate

        val reservationStartTimevalue = findViewById<TextView>(R.id.txt_reservation_start)
        reservationStartTimevalue.text = reservationStartTime

        val reservationEndTimevalue = findViewById<TextView>(R.id.txt_reservation_end)
        reservationEndTimevalue.text = reservationEndTime

        val reservationAvailablevalue = findViewById<TextView>(R.id.txt_reservation_status)
        reservationAvailablevalue.text = reservationAvailable.toString()
    }
}