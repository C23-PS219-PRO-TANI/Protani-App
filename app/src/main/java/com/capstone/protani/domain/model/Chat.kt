package com.capstone.protani.domain.model

data class Chat(
    val text:String,
    val isUserMessage:Boolean?=true
)