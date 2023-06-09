package com.capstone.protani.presentation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.capstone.protani.presentation.ui.theme.bottomBarColor
import com.capstone.protani.presentation.ui.theme.green200

@Composable
fun BottomAppBar(){
    var currentSelectedId by remember { mutableStateOf(0) }
    BottomAppBar(
        modifier=Modifier.fillMaxWidth(),
        backgroundColor = bottomBarColor,
        cutoutShape = CircleShape,
        contentPadding = PaddingValues(vertical = 10.dp),
        elevation = 2.dp
    ) {

    }
}

//@Composable
//@Preview
//fun SomePreviewLight(){
//    BottomAppBar()
//}