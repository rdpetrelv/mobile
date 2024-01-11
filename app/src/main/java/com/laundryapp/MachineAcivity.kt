package com.laundryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MachineAcivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_machine_acivity)

        val machineId=intent.getLongExtra(MainActivity.MACHINEID_PARAM,0)
        val name=intent.getStringExtra(MainActivity.NAME_PARAM)
        val available=intent.getBooleanExtra(MainActivity.AVAILABLE_PARAM, true)
        val machineStatus=intent.getBooleanExtra(MainActivity.MACHINESTATUS_PARAM, true)
        val progress=intent.getLongExtra(MainActivity.PROGRESS_PARAM, 0)

        val machineIdValue = findViewById<TextView>(R.id.txt_machine_machineIdValue)
        machineIdValue.text = machineId.toString()

        val nameValue = findViewById<TextView>(R.id.txt_machine_nameValue)
        nameValue.text = name

        val availableValue = findViewById<TextView>(R.id.txt_machine_available)
        availableValue.text = available.toString()

        val machineStatusValue = findViewById<TextView>(R.id.txt_machine_machineStatus)
        machineStatusValue.text = machineStatus.toString()

        val progressValue = findViewById<TextView>(R.id.txt_machine_progress)
        progressValue.text = progress.toString()

    }
}