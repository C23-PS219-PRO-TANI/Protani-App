package com.capstone.protani.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.protani.presentation.ui.theme.green200
import com.capstone.protani.presentation.ui.theme.green500

@Composable
fun BottomFontSlider(){
    var sliderPosition by remember { mutableStateOf(0f) }
    Box(modifier = Modifier
        .size(width = 100.dp, height = 100.dp)
    ){
        Text(text = sliderPosition.toString(), style = MaterialTheme.typography.body1)
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..50f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            steps = 1,
            colors = SliderDefaults.colors(
                thumbColor = green500,
                activeTrackColor = green200
            )
        )
    }
}

@Composable
@Preview
fun SomePreviewLight(){
    BottomFontSlider()
}