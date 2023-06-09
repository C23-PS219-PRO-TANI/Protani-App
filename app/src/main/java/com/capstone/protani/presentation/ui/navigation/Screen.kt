package com.capstone.protani.presentation.ui.navigation

sealed class Screen(val route:String) {
    object Splash: Screen("splash_screen")
    object Home: Screen("home_screen")
    object Wikipadi: Screen("wikipadi_screen")
    object About: Screen("about_screen")
    object CameraScanner: Screen("cameraScanner_screen")
    object ChatBot:Screen("chatbot_screen")
    object MapScreen:Screen("map_screen")

}