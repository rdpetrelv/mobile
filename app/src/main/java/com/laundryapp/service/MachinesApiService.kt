package com.laundryapp.service

import com.laundryapp.model.MachinesDto
import com.laundryapp.model.ReservationDto
import retrofit2.Call
import retrofit2.http.GET

interface MachinesApiService {
    @GET("machines")
    fun findAll(): Call<List<MachinesDto>>
}