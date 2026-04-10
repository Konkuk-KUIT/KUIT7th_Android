package com.example.kuit7_android.ui.features.homeDetail.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentBox(modifier: Modifier = Modifier, content: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.2.dp,
                color = Color(0xFF1877F2),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(20.dp)

    ){
        Text(
            text = content,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun pvCB() {
    ContentBox(content ="asdfljalsdfjal;sdjfalsdjfal;sdfjalks\ndjfalsdfjal;fj\nasjdflaksjdflajdf")
}