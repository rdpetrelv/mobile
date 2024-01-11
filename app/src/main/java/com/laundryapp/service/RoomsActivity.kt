package com.laundryapp.service

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laundryapp.BasicActivity
import com.laundryapp.MainActivity
import com.laundryapp.R
import com.laundryapp.adapter.SensorsAdapter
import com.laundryapp.interfaces.OnRoomClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomsActivity : BasicActivity(), OnRoomClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)

        val sensorsAdapter = SensorsAdapter(this)

        findViewById<RecyclerView>(R.id.list_rooms).also { recyclerView -> // (1)
            recyclerView.layoutManager = LinearLayoutManager(this) // (2)
            recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)) // (3)
            recyclerView.setHasFixedSize(true) // (4)
            recyclerView.adapter = sensorsAdapter // (5)
        }

        //roomsAdapter.setItems(RoomService.ROOMS)  // (6)

        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiService.ApiServices.sensorsApiService.findAll().execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (2)
                        sensorsAdapter.setItems(it.body() ?: emptyList()) }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) {
                        it.printStackTrace()
                        Toast.makeText(applicationContext, "Error on rooms loading $it", Toast.LENGTH_LONG)
                            .show()  // (3)
                    }
                }
        }
    }

    override fun selectRoom(id: Long) {
        val intent = Intent(this, RoomActivity::class.java).putExtra(MainActivity.ROOM_ID_PARAM, id)
        startActivity(intent)
    }
    override fun selectRoom2(id: Long, sensorDtoName: String, sensorDtoType: String, sensorDtoMeasure: Long) {
        val intent = Intent(this, RoomActivity::class.java).putExtra(MainActivity.SENSOR_ID_PARAM, id).putExtra(MainActivity.SENSOR_NAME_PARAM, sensorDtoName).putExtra(MainActivity.SENSOR_TYPE_PARAM, sensorDtoType).putExtra(MainActivity.SENSOR_MEASURE_PARAM, sensorDtoMeasure)
        startActivity(intent)
    }
}

private operator fun Unit.invoke(i: Int) {

}
