package com.capstone.protani.domain.model

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName

data class Map(
    @SerializedName("coordinat")
    val coordinate:String,
    @SerializedName("provence")
    val provence:String,
    @SerializedName("city")
    val city:String,
    @SerializedName("address")
    val address:String
)
