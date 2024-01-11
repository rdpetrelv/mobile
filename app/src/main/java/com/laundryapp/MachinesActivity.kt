package com.laundryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laundryapp.adapter.MachinesAdapter
import com.laundryapp.interfaces.OnMachineClickListener
import com.laundryapp.service.ApiServiceForMachines
import com.laundryapp.service.ApiServiceForReservation
import com.laundryapp.service.ReservationActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MachinesActivity : BasicActivity(), OnMachineClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)

        val machinesAdapter = MachinesAdapter(this)

        findViewById<RecyclerView>(R.id.list_rooms).also { recyclerView -> // (1)
            recyclerView.layoutManager = LinearLayoutManager(this) // (2)
            recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)) // (3)
            recyclerView.setHasFixedSize(true) // (4)
            recyclerView.adapter = machinesAdapter // (5)
        }

        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiServiceForMachines.ApiServicesForMachines.machinesApiService.findAll().execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (2)
                        machinesAdapter.setItems(it.body() ?: emptyList()) }
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

    override fun selectMachine2(
        machineId: Long,
        name: String,
        available: Boolean,
        machineStatus: Boolean,
        progress: Long
    ) {
        val intent = Intent(this, MachineAcivity::class.java).putExtra(MainActivity.MACHINEID_PARAM,machineId).putExtra(MainActivity.NAME_PARAM,name).putExtra(MainActivity.AVAILABLE_PARAM,available).putExtra(MainActivity.MACHINESTATUS_PARAM,machineStatus).putExtra(MainActivity.PROGRESS_PARAM,progress)

        startActivity(intent)
    }
}