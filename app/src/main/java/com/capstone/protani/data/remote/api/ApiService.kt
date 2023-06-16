package com.capstone.protani.data.remote.api

import com.capstone.protani.domain.model.Map
import com.capstone.protani.domain.model.MapResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("user-loc/create")
    fun setLocation(@Body map: Map):Call<MapResponse>

    @GET("user-loc/all?page=1&size=10")
    fun getAllCoordinate():Call<List<Map>>

}