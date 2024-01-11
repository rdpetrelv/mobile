package com.laundryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laundryapp.adapter.ReservationsAdapter
import com.laundryapp.interfaces.OnReservationClickListener
import com.laundryapp.service.ApiService
import com.laundryapp.service.ApiServiceForReservation
import com.laundryapp.service.ReservationActivity
import com.laundryapp.service.RoomService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservationsActivity : BasicActivity(), OnReservationClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)

        val reservationsAdapter = ReservationsAdapter(this)

        findViewById<RecyclerView>(R.id.list_rooms).also { recyclerView -> // (1)
            recyclerView.layoutManager = LinearLayoutManager(this) // (2)
            recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)) // (3)
            recyclerView.setHasFixedSize(true) // (4)
            recyclerView.adapter = reservationsAdapter // (5)
        }


        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiServiceForReservation.ApiServicesForReservation.reservationsApiService.findAll().execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (2)
                        reservationsAdapter.setItems(it.body() ?: emptyList()) }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) {
                        it.printStackTrace()
                        Toast.makeText(applicationContext, "Error on rooms loading $it", Toast.LENGTH_LONG)
                            .show()  // (3)
                    }
                }
        }
        //roomsAdapter.setItems(RoomService.ROOMS)  // (6)
    }

    override fun selectReservation(id: Long) {
        val intent = Intent(this, ReservationActivity::class.java).putExtra(MainActivity.ROOM_ID_PARAM, id)
        startActivity(intent)
    }

    override fun selectReservation2(id: Long,reservationUser: String, reservationDate: String, reservationStartTime: String, reservationEndTime: String, reservationAvailable: Boolean) {
        val intent = Intent(this, ReservationActivity::class.java).putExtra(MainActivity.RESERVATIONID_PARAM,id).putExtra(MainActivity.RESERVATIONUSER_PARAM,reservationUser).putExtra(MainActivity.RESERVATIONDATE_PARAM,reservationDate).putExtra(MainActivity.RESERVATIONSTARTTIME_PARAM,reservationStartTime).putExtra(MainActivity.RESERVATIONENDTIME_PARAM,reservationEndTime).putExtra(MainActivity.RESERVATIONAVAILABLE_PARAM,reservationAvailable)
        startActivity(intent)
    }
}