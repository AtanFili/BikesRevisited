package com.gsixacademy.android.bikesrevisited.api

import com.gsixacademy.android.bikesrevisited.models.BikeModel
import retrofit2.Call
import retrofit2.http.GET

interface BikesApi {
    @GET("networks")
    fun getBikes(): Call<BikeModel>
}