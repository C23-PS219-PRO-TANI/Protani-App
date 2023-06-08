package com.capstone.protani.ui.navigation

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.capstone.protani.ui.AboutScreen
import com.capstone.protani.ui.AnimatedSplashScreen
import com.capstone.protani.ui.CameraScannerScreen
import com.capstone.protani.ui.DeteksiPenyakitScreen
import com.capstone.protani.ui.HomeScreen
import com.capstone.protani.ui.WikipadiScreen


@Composable
fun SetupNavGraph(navController: NavHostController,context:Context){
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){ AnimatedSplashScreen(navController)}
        composable(route = Screen.Home.route){
            Box(modifier = Modifier.fillMaxSize()){
                HomeScreen(navController)
            }
        }
        composable(route = Screen.Wikipadi.route){
            Box(modifier = Modifier.fillMaxSize()){
                WikipadiScreen(navHostController = navController)
            }
        }
        composable(route = Screen.About.route){
            Box(modifier = Modifier.fillMaxSize()){
                AboutScreen(navHostController = navController)
            }
        }
        composable(route = Screen.CameraScanner.route){
            Box(modifier = Modifier.fillMaxSize()) {
                CameraScannerScreen(navController,context)
            }
        }
        composable(route = Screen.deteksiPenyakit.route){
            Box(modifier = Modifier.fillMaxSize()){
                DeteksiPenyakitScreen(navController)
            }
        }
    }
}