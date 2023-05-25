package com.capstone.protani.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBar(){
    var currentSelectedId by remember { mutableStateOf(0) }
    BottomAppBar(
        modifier=Modifier.fillMaxWidth(),
        backgroundColor = Color.Black,
        cutoutShape = CircleShape,
        contentPadding = PaddingValues(vertical = 20.dp),
        elevation = 2.dp
    ) {

    }
}

//@Composable
//@Preview
//fun SomePreviewLight(){
//    BottomAppBar()
//}