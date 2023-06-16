package com.capstone.protani.data.remote.api

import com.capstone.protani.presentation.viewmodels.Message
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAIApi {

    @Headers("Content-Type: application/json", "Authorization: Bearer ")
    // Api key OPEN AI tidak dimasukan karena, ketika dimasukan, aplikasi menjadi error, dan harus generate Api key OPEN AI yang baru

    @POST("v1/chat/completions")
    suspend fun generateResponse(@Body requestBody: OpenAIRequestBody): OpenAIResponse
}

data class OpenAIRequestBody(
    val model: String = "gpt-3.5-turbo",
    val messages: List<Message>,
    val max_tokens: Int = 80,
    val n: Int = 1,
    val temperature: Double = 1.0
)

data class OpenAIResponse(
    val choices: List<MessageResponse>
)

data class MessageResponse(
    val message: Message
)
