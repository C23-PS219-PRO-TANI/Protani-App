package com.capstone.protani.domain.model


import com.google.gson.annotations.SerializedName

data class GetAllMapResponse(
    @SerializedName("data")
    val data: Data
)