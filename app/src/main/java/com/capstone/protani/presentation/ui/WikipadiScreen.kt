package com.capstone.protani.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.capstone.protani.R
import com.capstone.protani.domain.data.DiseaseData
import com.capstone.protani.domain.model.Disease
import com.capstone.protani.presentation.ui.navigation.Screen
import com.capstone.protani.presentation.ui.theme.modalColor

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
                    .background(if (isSystemInDarkTheme()) Color.White else Color.White)
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
                    ) {
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
                val selectedTabIndex = remember { mutableStateOf(0) }
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
                    Column(modifier=Modifier
                        .size(width = 435.dp, height = 500.dp)
                    ){
                        TabLayout(items = items, selectedTabIndex = selectedTabIndex)
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


@Composable
fun TabLayout(items: List<Disease>, selectedTabIndex: MutableState<Int>) {
    val titles = items.map { it.title }

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .offset {
                            IntOffset(
                                x = tabPositions[selectedTabIndex.value].left.roundToPx(),
                                y = 0
                            )
                        }
                )
            },
            divider = {}
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    onClick = { selectedTabIndex.value = index },
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)
                        .background(
                            color = if (selectedTabIndex.value == index) modalColor else Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = modalColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }

        val selectedDisease = items[selectedTabIndex.value]
        DiseaseInfoItem(disease = selectedDisease)
    }
}



@Composable
fun DiseaseInfoItem(disease: Disease) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = disease.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = disease.body,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Justify
        )
    }
}

