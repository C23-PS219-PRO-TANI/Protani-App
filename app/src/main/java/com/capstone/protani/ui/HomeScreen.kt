package com.capstone.protani.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.capstone.protani.R
import com.capstone.protani.ui.theme.blue200
import com.capstone.protani.ui.theme.cardColor
import com.capstone.protani.ui.theme.green200

@Composable
fun HomeScreen(){

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

        Text(
            text = stringResource(id = R.string.fitur_protani),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 10.dp)
        )
//        Column(modifier=Modifier.) {
//
//        }
    }

}

@Composable
@Preview
fun SomePreviewLight(){
    HomeScreen()
}