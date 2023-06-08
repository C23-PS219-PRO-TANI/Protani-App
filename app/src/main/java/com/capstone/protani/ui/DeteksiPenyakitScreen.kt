package com.capstone.protani.ui

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.capstone.protani.R
import com.capstone.protani.ui.navigation.Screen
import com.capstone.protani.ui.viewmodels.PlantViewModel

@Composable
fun DeteksiPenyakitScreen(navHostController:NavHostController){
    val plantViewModel = viewModel<PlantViewModel>()
    val currentLayoutDir = LocalLayoutDirection.current
    Scaffold(backgroundColor = Color.White) { padding->
        Column(modifier= Modifier
            .padding(padding)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            ) {
                Image(
                    modifier= Modifier.size(width = 140.dp, height = 140.dp),
                    painter = painterResource(id = R.drawable.ellipse_16),
                    contentDescription = "ellipse_16"
                )
                Image(
                    modifier= Modifier
                        .size(width = 200.dp, height = 200.dp)
                        .padding(
                            start = padding.calculateStartPadding(currentLayoutDir) + 90.dp
                        )
                        .align(Alignment.TopEnd),
                    painter = painterResource(id = R.drawable.green_vector),
                    contentDescription = "green_vector"
                )
                Row(modifier = Modifier
                    .align(Alignment.TopStart)
                    .clickable {
                        navHostController.popBackStack()
                        navHostController.navigate(Screen.CameraScanner.route)
                    }
                    .zIndex(1f)) {
                    Image(
                        modifier= Modifier
                            .padding(
                                top = padding.calculateTopPadding() + 50.dp,
                                start = padding.calculateStartPadding(currentLayoutDir) + 20.dp
                            )
                            .size(width = 30.dp, height = 30.dp)
                        ,
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "arrowBack"
                    )
                }
                Row(
                    modifier= Modifier.align(Alignment.TopCenter),
                ){
                    Column(modifier = Modifier
                        .padding(top = padding.calculateTopPadding() + 50.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.title_diagnose),
                            contentDescription = "topAppBar"
                        )
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "Deteksi Penyakit",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }

                Column(
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(700.dp)
                        .padding(top = 30.dp)
                        .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val nameDisease =  plantViewModel.dataDesease.observeAsState().value
                    Log.d("nameDisease","$nameDisease")
                }

            }
        }


    }
}