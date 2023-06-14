package com.capstone.protani.domain.model
data class Disease(
    val id:Int,
    val photoUrl:String?=null,
    val title:String,
    val body:String,
    val diagnosis:String,
)
