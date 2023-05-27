package com.capstone.protani.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.capstone.protani.R
import com.capstone.protani.ui.theme.yellowFAB
import com.capstone.protani.ui.components.BottomAppBar
import com.capstone.protani.ui.navigation.Screen
import com.capstone.protani.ui.theme.blue200
import com.capstone.protani.ui.theme.green500

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun HomeScreen(navController: NavHostController){
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        backgroundColor = Color.White,
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                backgroundColor = yellowFAB,
                contentColor = MaterialTheme.colors.background,
                elevation = FloatingActionButtonDefaults.elevation(2.dp,3.dp)
            ) {
                Icon(
                    modifier=Modifier.size(width = 32.dp, height = 32.dp),
                    painter = painterResource(id = R.drawable.diagnose),
                    contentDescription = "diagnose_rice_plant"
                )
            }
        },
        bottomBar = { BottomAppBar()}
    ){
        Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            ){
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxWidth()
                        .padding(top = 40.dp, start = 10.dp)
                        .zIndex(3f),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        modifier=Modifier.size(50.dp,50.dp),
                        painter = painterResource(id = R.drawable.profile_tani),
                        contentDescription = stringResource(
                            id = R.string.profile)
                    )
                    Text(
                        text = stringResource(id = R.string.welcoming_text),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    val checkedState = remember{
                        mutableStateOf(false)
                    }
                    Switch(
                        modifier=Modifier.padding(start = 50.dp),
                        checked = checkedState.value,
                        onCheckedChange = {checkedState.value = it},
                        colors = SwitchDefaults.colors(blue200),
                    )
                }
                Image(
                    modifier= Modifier
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
                    modifier= Modifier
                        .padding(top = 32.dp, start = 12.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Column{
                        Text(
                            text = stringResource(id = R.string.fitur_protani),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(start = 10.dp),
                        )
                        val context = LocalContext.current
                        Row(modifier=Modifier.padding(start = 10.dp)) {
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp)
                                    .clickable {
                                        navController.popBackStack()
                                        navController.navigate(Screen.Wikipadi.route)
                                    },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                ) {
                                    Row(modifier=Modifier
                                        .align(Alignment.Start)) {
                                        Image(
                                            modifier=Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.wikipadi),
                                            contentDescription = "Wikipadi"
                                        )
                                        Text(
                                            modifier=Modifier.align(Alignment.CenterVertically),
                                            text="Wikipadi",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color= green500,
                                            fontFamily = FontFamily(Font(R.font.netflix_sans))
                                        )

                                    }

                                }
                            }
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp, start = 10.dp)
                                    .clickable { Toast.makeText(context,"clicked!",Toast.LENGTH_SHORT).show() },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                ) {
                                    Row(modifier=Modifier
                                        .align(Alignment.Start)) {
                                        Image(
                                            modifier=Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.chatbot),
                                            contentDescription = "ChatBot"
                                        )
                                        Text(
                                            modifier=Modifier.align(Alignment.CenterVertically),
                                            text="ChatBot",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color= green500,
                                            fontFamily = FontFamily(Font(R.font.netflix_sans))
                                        )
                                    }

                                }
                            }
                        }
                        Row(modifier=Modifier.padding(start = 10.dp)) {
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp)
                                    .clickable { Toast.makeText(context,"clicked!",Toast.LENGTH_SHORT).show() },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                ) {
                                    Row(modifier=Modifier
                                        .align(Alignment.Start)) {
                                        Image(
                                            modifier=Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.tentangaplikasi),
                                            contentDescription = "aboutApp"
                                        )
                                        Text(
                                            modifier= Modifier
                                                .padding(start = 10.dp)
                                                .align(Alignment.CenterVertically),
                                            text="Tentang\nAplikasi",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color= green500,
                                            fontFamily = FontFamily(Font(R.font.netflix_sans))
                                        )

                                    }

                                }
                            }
                            Card(
                                modifier = Modifier
                                    .size(width = 156.dp, height = 100.dp)
                                    .padding(top = 32.dp, start = 10.dp)
                                    .clickable {  },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                ) {
                                    Row(modifier=Modifier
                                        .align(Alignment.Start)) {
                                        Image(
                                            modifier=Modifier.size(width = 60.dp, height = 60.dp),
                                            painter = painterResource(id = R.drawable.petasebaran),
                                            contentDescription = "petaSebaran"
                                        )
                                        Text(
                                            modifier= Modifier
                                                .padding(start = 10.dp)
                                                .align(Alignment.CenterVertically),
                                            text="Peta\nSebaran",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color= green500,
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

//@Composable
//@Preview
//fun SomePreviewLight(){
//    HomeScreen()
//}