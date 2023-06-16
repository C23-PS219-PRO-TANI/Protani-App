package com.capstone.protani.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.capstone.protani.R
import com.capstone.protani.presentation.ui.navigation.Screen
import com.capstone.protani.presentation.ui.theme.bottomBarColor
import com.capstone.protani.presentation.ui.theme.green500
import com.capstone.protani.presentation.ui.theme.yellowFAB

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

fun HomeScreen(navController: NavHostController) {

    val isDarkTheme = currentThemeMode == ThemeMode.Dark
    MaterialTheme(colors = if (isDarkTheme) darkColors() else lightColors()) {
        Scaffold(
            scaffoldState = rememberScaffoldState(),
            backgroundColor = Color.White,
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate(Screen.CameraScanner.route) },
                    backgroundColor = yellowFAB,
                    contentColor = MaterialTheme.colors.background,
                    elevation = FloatingActionButtonDefaults.elevation(2.dp, 3.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(width = 32.dp, height = 32.dp),
                        painter = painterResource(id = R.drawable.diagnose),
                        contentDescription = "diagnose_rice_plant"
                    )
                }
            },
            bottomBar = { com.capstone.protani.presentation.ui.components.BottomAppBar() }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(if (isSystemInDarkTheme()) Color.White else Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxWidth()
                        .padding(top = 40.dp, start = 10.dp)
                        .zIndex(3f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(50.dp, 50.dp),
                        painter = painterResource(id = R.drawable.profile_tani),
                        contentDescription = stringResource(
                            id = R.string.profile
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.welcoming_text),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    val checkedState = remember {
                        mutableStateOf(false)

                    }
                }
                Image(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .zIndex(1f)
                        .padding(10.dp)
                        .size(250.dp),
                    painter = painterResource(id = R.drawable.scratch),
                    contentDescription = stringResource(id = R.string.scratch)
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 110.dp)
                        .size(width = 312.dp, height = 143.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(width = 10.dp, color = Color.White)
                        .zIndex(2f),
                    painter = painterResource(id = R.drawable.kakek_cangkul),
                    contentDescription = stringResource(id = R.string.kakek_desc)
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(0f),
                    painter = painterResource(id = R.drawable.vector_12),
                    contentDescription = stringResource(id = R.string.protani_logo),
                )
                Row(
                    modifier = Modifier
                        .padding(top = 150.dp, end = 20.dp)
                        .align(Alignment.Center)
                ) {
                    Column {
                        val context = LocalContext.current
                        Row(modifier = Modifier.padding(start = 10.dp)) {
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp)
                                    .clickable {
                                        navController.popBackStack()
                                        navController.navigate(Screen.Wikipadi.route)
                                    },
                                shape = RoundedCornerShape(10.dp),
                                backgroundColor = bottomBarColor

                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .align(Alignment.Start)
                                    ) {
                                        Image(
                                            modifier = Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.wikipadi),
                                            contentDescription = "Wikipadi"
                                        )
                                        Text(
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            text = "Wikipadi",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = green500,
                                            fontFamily = FontFamily(Font(R.font.netflix_sans))
                                        )

                                    }

                                }
                            }
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp, start = 10.dp)
                                    .clickable { navController.navigate(Screen.ChatBot.route) },
                                shape = RoundedCornerShape(10.dp),
                                backgroundColor = bottomBarColor
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .align(Alignment.Start)
                                    ) {
                                        Image(
                                            modifier = Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.chatbot),
                                            contentDescription = "ChatBot"
                                        )
                                        Text(
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            text = "ChatBot",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = green500,
                                            fontFamily = FontFamily(Font(R.font.netflix_sans))
                                        )
                                    }

                                }
                            }
                        }
                        Row(modifier = Modifier.padding(start = 10.dp)) {
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp)
                                    .clickable {
                                        navController.popBackStack()
                                        navController.navigate(Screen.About.route)
                                    },
                                shape = RoundedCornerShape(10.dp),
                                backgroundColor = bottomBarColor
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .align(Alignment.Start)
                                    ) {
                                        Image(
                                            modifier = Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.tentangaplikasi),
                                            contentDescription = "aboutApp"
                                        )
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                                .align(Alignment.CenterVertically),
                                            text = "Tentang\nAplikasi",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = green500,
                                            fontFamily = FontFamily(Font(R.font.netflix_sans))
                                        )

                                    }

                                }
                            }
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp, start = 10.dp)
                                    .clickable { navController.navigate(Screen.MapScreen.route) },
                                shape = RoundedCornerShape(10.dp),
                                backgroundColor = bottomBarColor
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .align(Alignment.Start)
                                    ) {
                                        Image(
                                            modifier = Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.petasebaran),
                                            contentDescription = "petaSebaran"
                                        )
                                        Text(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                                .align(Alignment.CenterVertically),
                                            text = "Peta\nSebaran",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = green500,
                                            fontFamily = FontFamily(Font(R.font.netflix_sans)),
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

enum class ThemeMode {
    Light, Dark
}
var currentThemeMode by mutableStateOf(ThemeMode.Light)

fun toggleThemeMode() {
    currentThemeMode = when (currentThemeMode) {
        ThemeMode.Light -> ThemeMode.Dark
        ThemeMode.Dark -> ThemeMode.Light
    }
}
