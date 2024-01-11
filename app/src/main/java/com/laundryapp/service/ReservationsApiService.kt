package com.laundryapp.service

import com.laundryapp.model.ReservationDto
import retrofit2.Call
import retrofit2.http.GET

interface ReservationsApiService {
    @GET("reservation")
    fun findAll(): Call<List<ReservationDto>>
}