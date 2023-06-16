package com.capstone.protani.domain.model

import com.google.android.gms.maps.model.LatLng

data class Map(
    val coordinate:LatLng,
    val provence:String,
    val city:String,
    val address:String
)
