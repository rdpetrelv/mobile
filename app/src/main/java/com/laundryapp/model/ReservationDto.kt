package com.laundryapp.model

data class ReservationDto(
    val reservationId: Long,
    val reservationUser: String,
    val reservationDate: String,
    val reservationStartTime: String,
    val reservationEndTime: String,
    val reservationAvailable: Boolean
)
