package com.laundryapp.interfaces

interface OnRoomClickListener {
    fun selectRoom(id: Long)
    fun selectRoom2(id: Long, sensorDtoName: String, sensorDtoType: String, sensorDtoMeasure: Long)
}