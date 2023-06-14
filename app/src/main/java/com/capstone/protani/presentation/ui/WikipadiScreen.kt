package com.capstone.protani.presentation.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.capstone.protani.R
import com.capstone.protani.domain.data.DiseaseData
import com.capstone.protani.presentation.ui.components.DiseasesListItem
import com.capstone.protani.presentation.ui.navigation.Screen

@Composable
fun WikipadiScreen(navHostController: NavHostController){
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
                    modifier=Modifier.size(width = 140.dp, height = 140.dp),
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
                        navHostController.navigate(Screen.Home.route)
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
                            painter = painterResource(id = R.drawable.icon_logo),
                            contentDescription = "topAppBar"
                        )
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "Wikipadi",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
                val items = remember { DiseaseData.disease }
                Column(
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(700.dp)
                        .padding(top = 30.dp)
                        .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier= Modifier
                            .padding(top = 10.dp)
                            .width(300.dp)
                            .height(170.dp),
                        painter = painterResource(id = R.drawable.sawah),
                        contentDescription = "sawah"
                    )
                    LazyColumn(modifier=Modifier
                        .size(width = 400.dp, height = 400.dp)
                    ){
                        itemsIndexed(items){_,item->
                            DiseasesListItem(title = item.title, body = item.body, modifier = Modifier)
                        }
                    }
                }

            }
        }


    }
}

//@Composable
//@Preview
//fun SomePreviewLight(){
//    WikipadiScreen()
//}