package com.capstone.protani.domain.model


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("active")
    val active: Boolean, // false
    @SerializedName("label")
    val label: String, // &laquo; Previous
    @SerializedName("url")
    val url: String // http://ajakan.xyz/api/user-loc/all?page=1
)