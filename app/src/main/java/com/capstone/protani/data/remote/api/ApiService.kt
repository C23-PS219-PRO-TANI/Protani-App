package com.capstone.protani.data.remote.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

import com.capstone.protani.domain.model.GetAllMapResponse
import com.capstone.protani.domain.model.Map
import com.capstone.protani.domain.model.MapResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    enum class ApiStatus { LOADING, SUCCESS, FAILED }

    @POST("user-loc/create")
    fun setLocation(@Body map: Map): Call<MapResponse>

    @GET("user-loc/all?page=1&size=10")
    fun getAllCoordinate(): Call<GetAllMapResponse>

}