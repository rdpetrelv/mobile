package com.laundryapp.interfaces

interface OnReservationClickListener {
    fun selectReservation(id: Long)
    fun selectReservation2(id: Long, reservationUser: String, reservationDate: String, reservationStartTime: String, reservationEndTime: String, reservationAvailable: Boolean)
}