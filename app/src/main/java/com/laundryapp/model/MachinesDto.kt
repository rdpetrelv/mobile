package com.laundryapp.model

data class MachinesDto(
    val machineId: Long,
    val name: String,
    val available: Boolean,
    val machineStatus: Boolean,
    val progress: Long
    )
