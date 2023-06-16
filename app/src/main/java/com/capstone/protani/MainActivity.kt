package com.capstone.protani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.capstone.protani.presentation.ui.navigation.SetupNavGraph
import com.capstone.protani.presentation.ui.theme.ProtaniTheme
import com.google.accompanist.pager.ExperimentalPagerApi


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProtaniTheme {
//                val windowInfo = rememberWindowInfo()
//                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact && windowInfo.screenHeightInfo is WindowInfo.WindowType.Compact){}
                    val controller = rememberNavController()
                    SetupNavGraph(navController = controller, context = this)

            }
        }
    }
}
