package com.capstone.protani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.capstone.protani.ui.navigation.SetupNavGraph
import com.capstone.protani.ui.theme.ProtaniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProtaniTheme {
                val controller = rememberNavController()
                SetupNavGraph(navController = controller)
            }
        }
    }
}
