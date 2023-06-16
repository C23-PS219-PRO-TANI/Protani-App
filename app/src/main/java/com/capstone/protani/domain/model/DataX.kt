package com.capstone.protani.domain.model


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("address")
    val address: String, // xxxx
    @SerializedName("city")
    val city: String, // xxxx
    @SerializedName("coordinat")
    val coordinat: String, // xxxx
    @SerializedName("created_at")
    val createdAt: String, // 2023-06-15T10:51:33.000000Z
    @SerializedName("id")
    val id: Int, // 1
    @SerializedName("provence")
    val provence: String, // xxxx
    @SerializedName("updated_at")
    val updatedAt: String // 2023-06-15T10:51:33.000000Z
)