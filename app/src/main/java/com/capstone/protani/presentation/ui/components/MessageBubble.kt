package com.capstone.protani.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun MessageBubble(text: String, isUserMessage: Boolean) {
    val bubbleColor = if (isUserMessage) Color(0xFFBBDEFB) else Color.White
    val textColor = if (isUserMessage) Color.Black else Color.Black
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(bubbleColor, shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.body1
        )
    }
}
