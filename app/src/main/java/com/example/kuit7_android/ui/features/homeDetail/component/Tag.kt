package com.example.kuit7_android.ui.features.homeDetail.component

import androidx.compose.foundation.background
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
fun Tag(modifier: Modifier = Modifier, tag : String) {
    Box(
        modifier = Modifier
            .background(
                color = Color(0xFF1877F2),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(8.dp, 1.dp)
    ){
        Text(
            text = tag,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun Tagprew() {
    Tag(tag = "Europe")
}