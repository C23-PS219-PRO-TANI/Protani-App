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
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.capstone.protani.R
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
                    .background(if (isSystemInDarkTheme()) Color.White else Color.White)
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
                        .padding(top = 10.dp)
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
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(modifier= Modifier
                        .padding(top = 30.dp)
                        .size(width = 400.dp, height = 400.dp)
                    ){
                        Text(
                            text = "Apa itu PRO-Tani ?",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 8.dp).align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = "PRO-Tani adalah Aplikasi Deteksi Kesehatan Padi dan Solusi untuk membantu para Petani di Indonesia.\n" +
                                    "\n" +
                                    "Aplikasi ini mampu mendeteksi 4 penyakit pada padi dan memberikan solusi penanganannya melalui chatbot yang tersedia. Tidak hanya itu hasil dari deteksi dapat ditandai pada peta sebaran, sebagai monitor untuk melihat daerah mana saja yang paling banyak memiliki permasalahan pada padinya.\n" +
                                    "\n" +
                                    "Aplikasi ini di kembangkan oleh : \n" +
                                    "\n" +
                                    "M228DSX0248 – Glenhans Kuaya Fredlino\n" +
                                    "M228DSX0155 – Anugrah Igo Aldi Wibowo\n" +
                                    "C305DSY3147 – Rischa Nuril Fadila\n" +
                                    "C166DSX2206 – Lukman Ernandi\n" +
                                    "A296DSX1690 – Hanif Hanan Al-Jufri\n" +
                                    "A360DSX2276 – Muhammad Yaumil Ramadhani",
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