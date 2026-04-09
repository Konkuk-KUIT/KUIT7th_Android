package com.example.kuit7_android.navigation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectDemoScreen(
    modifier:
    Modifier = Modifier,
) {
    var count by remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = count){
        delay(3000L)
        Log.d("countValue", "$count")
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Current Value : $count", fontSize = 40.sp)
        Button(
            onClick = { count++ }
        ) {
            Text("Increment Count")
        }
    }
}

@Preview
@Composable
fun launchedeffectdemopreview(){
    LaunchedEffectDemoScreen()
}