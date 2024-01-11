package com.laundryapp.model

data class SensorDto(
    val id: Long,
    val name: String,
    val currentTemperature: Double?,
    val targetTemperature: Double?,
    val windows: List<WindowDto>,
    val sensorId: Long,
    val sensorName: String,
    val status: Boolean,
    val sensorType: String,
    val measure: Long
)
