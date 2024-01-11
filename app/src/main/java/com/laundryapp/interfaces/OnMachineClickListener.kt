package com.laundryapp.interfaces

interface OnMachineClickListener {
    fun selectMachine2(machineId: Long,name: String,available: Boolean,machineStatus: Boolean,progress: Long)
}