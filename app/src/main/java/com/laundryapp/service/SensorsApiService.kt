package com.laundryapp.service

import com.laundryapp.model.SensorDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SensorsApiService {
    @GET("sensors")
    fun findAll(): Call<List<SensorDto>>

    @GET("sensors/by-id/{id}")
    fun findById(@Path("id") id: Long): Call<SensorDto>

}