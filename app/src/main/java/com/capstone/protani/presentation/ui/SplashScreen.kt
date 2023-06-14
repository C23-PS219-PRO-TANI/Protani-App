package com.capstone.protani.presentation.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.capstone.protani.R
import com.capstone.protani.presentation.ui.navigation.Screen
import com.capstone.protani.presentation.ui.theme.green500
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController:NavHostController){
    var startAnimation by remember{ mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation)1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Splash(alphaAnimation = alphaAnim.value)
}

@Composable
fun Splash(alphaAnimation: Float){
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else green500)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.alpha(alpha = alphaAnimation),
                painter = painterResource(id = R.drawable.logo_2),
                contentDescription = stringResource(id = R.string.protani_logo),
                contentScale = ContentScale.None
            )

            Text(
                text = stringResource(id = R.string.title_protani),
                color= Color.White,
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.reenie_regular))
            )
        }
        Image(
            modifier = Modifier
                .alpha(alpha = alphaAnimation)
                .align(Alignment.BottomStart),
            painter = painterResource(id = R.drawable.wave),
            contentDescription = stringResource(id = R.string.protani_logo),
            contentScale = ContentScale.None,
        )
    }
}

//@Composable
//@Preview
//fun SomePreviewLight(){
//    Splash(1f)
//}

//@Composable
//@Preview(uiMode = UI_MODE_NIGHT_YES)
//fun SomePreviewDark(){
//    Splash(1f)
//}