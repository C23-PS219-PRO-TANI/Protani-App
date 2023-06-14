package com.capstone.protani.presentation.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.capstone.protani.domain.model.Chat
import com.capstone.protani.presentation.ui.components.MessageBubble

@Composable
fun ChatBot(navHostController: NavHostController){
    val textChat = remember { mutableStateOf(TextFieldValue("")) }
    val message = remember{ mutableStateOf("") }
    Log.d("value chat","${textChat.value}")
    Box(modifier=Modifier.padding(top=50.dp).fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFECECEC))
                .padding(16.dp)
        ) {
            // Chat messages
            Column(modifier = Modifier.weight(1f)) {
                MessageBubble(
                    text = "text",
                    isUserMessage = true
                )
            }
        }
        // User input
        Row(
            modifier = Modifier
                .padding(bottom = 80.dp, start = 20.dp, end = 20.dp)
                .align(Alignment.BottomCenter)
        ) {
            OutlinedTextField(
                value = textChat.value,
                placeholder = { Text(text = "Ketik pertanyaan disini.....")},
                onValueChange = {textChat.value = it},
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {},
                modifier=Modifier.height(55.dp)
            ) {
                Text("Tanya")
            }
        }
    }
    }
