package com.capstone.protani.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.capstone.protani.R

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
    ){
        Canvas(
            modifier = Modifier
                .width(337.dp)
                .height(167.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .zIndex(2f)
        ){

        }
        Image(
            modifier= Modifier
                .align(Alignment.TopEnd)
                .zIndex(1f)
                .padding(10.dp)
                .size(250.dp)
            ,
            painter = painterResource(id = R.drawable.scratch),
            contentDescription = stringResource(id = R.string.scratch)
        )
        Image(
            modifier=Modifier.zIndex(0f),
            painter = painterResource(id = R.drawable.vector_12),
            contentDescription = stringResource(id = R.string.protani_logo),
            contentScale = ContentScale.FillWidth,
        )

    }
}

@Composable
@Preview
fun SomePreviewLight(){
    HomeScreen()
}