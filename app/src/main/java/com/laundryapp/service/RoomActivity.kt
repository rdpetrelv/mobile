package com.laundryapp.service

import android.os.Bundle
import android.widget.TextView
import com.laundryapp.BasicActivity
import com.laundryapp.MainActivity
import com.laundryapp.R

class RoomActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

//        val reservationId=intent.getLongExtra(MainActivity.RESERVATIONID_PARAM,0)
//        val reservationUser=intent.getStringExtra(MainActivity.RESERVATIONUSER_PARAM)
//        val reservationDate=intent.getStringExtra(MainActivity.RESERVATIONDATE_PARAM)
//        val reservationStartTime=intent.getStringExtra(MainActivity.RESERVATIONSTARTTIME_PARAM)
//        val reservationEndTime=intent.getStringExtra(MainActivity.RESERVATIONENDTIME_PARAM)
//        val reservationAvailable=intent.getStringExtra(MainActivity.RESERVATIONAVAILABLE_PARAM)


        val roomId = intent.getLongExtra(MainActivity.ROOM_ID_PARAM, 0)
        val sensorType = intent.getStringExtra(MainActivity.SENSOR_TYPE_PARAM)
        val sensorName = intent.getStringExtra(MainActivity.SENSOR_NAME_PARAM)
        val sensorId = intent.getLongExtra(MainActivity.SENSOR_ID_PARAM, 0)
        val sensorMeasure = intent.getLongExtra(MainActivity.SENSOR_MEASURE_PARAM, 0)
        val room = RoomService.ROOMS.firstOrNull {it.id == roomId}


//        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
//            runCatching { ApiService.ApiServices.sensorsApiService.findById(roomId).execute() }
//                .onSuccess {
//                    withContext(context = Dispatchers.Main) { // (2)
//                        roomsAdapter.setItems(it.body() ?: emptyList()) }
//                }
//                .onFailure {
//                    withContext(context = Dispatchers.Main) {
//                        it.printStackTrace()
//                        Toast.makeText(applicationContext, "Error on rooms loading $it", Toast.LENGTH_LONG)
//                            .show()  // (3)
//                    }
//                }
//        }

//        val idValue = findViewById<TextView>(R.id.txt_reservation_id)
//        idValue.text = reservationId.toString()
//
//        val userValue = findViewById<TextView>(R.id.txt_reservation_user)
//        userValue.text = reservationUser
//
//        val reservationDatevalue = findViewById<TextView>(R.id.txt_reservation_date)
//        reservationDatevalue.text = reservationDate
//
//        val reservationStartTimevalue = findViewById<TextView>(R.id.txt_reservation_start)
//        reservationStartTimevalue.text = reservationStartTime
//
//        val reservationEndTimevalue = findViewById<TextView>(R.id.txt_reservation_end)
//        reservationEndTimevalue.text = reservationEndTime
//
//        val reservationAvailablevalue = findViewById<TextView>(R.id.txt_reservation_status)
//        reservationAvailablevalue.text = reservationAvailable

        val idValue = findViewById<TextView>(R.id.txt_sensor_id)
        idValue.text = sensorId.toString()

        val nameValue = findViewById<TextView>(R.id.txt_sensor_name)
        nameValue.text = sensorName.toString()

        val typeValue = findViewById<TextView>(R.id.txt_sensor_type)
        typeValue.text = sensorType

        val measureValue = findViewById<TextView>(R.id.txt_sensor_measure)
        measureValue.text = sensorMeasure.toString()

//        val roomTargetTemperature = findViewById<TextView>(R.id.txt_sensor_measure)
//        //roomTargetTemperature.text = room?.targetTemperature?.toString() ?: ""
//        roomTargetTemperature.text = sensorType
    }
}