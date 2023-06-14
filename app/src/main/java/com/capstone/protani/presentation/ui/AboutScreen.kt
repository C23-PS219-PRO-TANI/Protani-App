package com.capstone.protani.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.capstone.protani.R
import com.capstone.protani.domain.data.DiseaseData
import com.capstone.protani.presentation.ui.components.DiseasesListItem
import com.capstone.protani.presentation.ui.navigation.Screen

@Composable

fun AboutScreen(navHostController: NavHostController){
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
                Column(modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = padding.calculateTopPadding() + 65.dp),
                ) {
                    Image(
                        modifier=Modifier.padding(start =
                        padding.calculateStartPadding(currentLayoutDir) + 40.dp),
                        painter = painterResource(id = R.drawable.about_us),
                        contentDescription = "about_us"
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Tentang Aplikasi",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Column(
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(670.dp)
                        .padding(top = 30.dp)
                        .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier= Modifier
                            .padding(top = 10.dp)
                            .width(140.dp)
                            .height(140.dp),
                        painter = painterResource(id = R.drawable.logo_2),
                        contentDescription = "logo_protani"
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(modifier= Modifier
                        .padding(top = 30.dp)
                        .size(width = 300.dp, height = 400.dp)
                    ){
                        Text(
                            text = "Apa itu PRO-Tani ?",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque at ex a lectus dictum aliquam. Vestibulum congue, turpis et maximus finibus, augue metus tristique ex, a blandit mauris ligula at felis. Nunc congue massa id eros lacinia gravida. Donec dictum accumsan lacus, in tristique elit pharetra et. Nunc molestie nulla non venenatis egestas. Fusce at augue ac turpis laoreet rutrum ut a odio. Pellentesque at porta tortor. Vestibulum consectetur dignissim fermentum. Pellentesque sed feugiat velit. Integer vulputate interdum justo ac dictum. Nam vel dictum elit. Nullam quis massa eu risus venenatis blandit. Curabitur sed justo finibus lectus luctus ornare vel sit amet orci. Nullam blandit ex at nibh pharetra, et lobortis lectus elementum.",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
        }
    }
    BackHandler {
        navHostController.popBackStack()
        navHostController.navigate(Screen.Home.route)
    }
}