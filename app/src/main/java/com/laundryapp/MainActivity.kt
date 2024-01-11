package com.laundryapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.laundryapp.service.ReservationActivity
import com.laundryapp.service.RoomActivity
import com.laundryapp.service.RoomsActivity

class MainActivity : BasicActivity() {
    companion object {
        const val WINDOW_NAME_PARAM = "com.laundryapp.windowname.attribute"
        const val ROOM_ID_PARAM = "com.laundryapp.roomid.attribute"
        const val SENSOR_NAME_PARAM = "com.laundryapp.sensornamez.attribute"
        const val SENSOR_TYPE_PARAM = "com.laundryapp.sensortype.attribute"
        const val SENSOR_MEASURE_PARAM = "com.laundryapp.sensormeasure.attribute"
        const val SENSOR_ID_PARAM = "com.laundryapp.sensorid.attribute"
        const val RESERVATIONID_PARAM= "com.laundryapp.reservationId.attribute"
        const val RESERVATIONUSER_PARAM= "com.laundryapp.reservationUser.attribute"
        const val RESERVATIONDATE_PARAM= "com.laundryapp.reservationDate.attribute"
        const val RESERVATIONSTARTTIME_PARAM= "com.laundryapp.reservationStartTime.attribute"
        const val RESERVATIONENDTIME_PARAM= "com.laundryapp.reservationEndTime.attribute"
        const val RESERVATIONAVAILABLE_PARAM= "com.laundryapp.reservationAvailable.attribute"
        const val MACHINEID_PARAM= "com.laundryapp.machineId.attribute"
        const val NAME_PARAM= "com.laundryapp.name.attribute"
        const val AVAILABLE_PARAM= "com.laundryapp.available.attribute"
        const val MACHINESTATUS_PARAM= "com.laundryapp.machineStatus.attribute"
        const val PROGRESS_PARAM= "com.laundryapp.progress.attribute"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the button */
    fun openWindow(view: View) {
        // Extract value filled in editext identified with txt_window_name id
        //val windowName = findViewById<EditText>(R.id.txt_window_name).text.toString()

        val intent = Intent(this, MachinesActivity::class.java).apply {
            putExtra(WINDOW_NAME_PARAM, "0")
        }
        startActivity(intent)
    }

    fun openRoom(view: View) {
        val intent = Intent(this, RoomActivity::class.java).apply {
            putExtra(ROOM_ID_PARAM, 1L)
            //putExtra(SENSOR_TYPE_PARAM, "0")
        }
        startActivity(intent)
    }

    fun openRoomsView(view: View) {
        val intent = Intent(this, RoomsActivity::class.java).apply {
            //putExtra(ROOM_ID_PARAM, 1L)
            //putExtra(SENSOR_TYPE_PARAM, "0")
        }
        startActivity(intent)
    }

    fun openReservationsView(view: View) {
        val intent = Intent(this, ReservationsActivity::class.java).apply {
            //putExtra(ROOM_ID_PARAM, 1L)
            //putExtra(SENSOR_TYPE_PARAM, "0")
        }
        startActivity(intent)
    }
}