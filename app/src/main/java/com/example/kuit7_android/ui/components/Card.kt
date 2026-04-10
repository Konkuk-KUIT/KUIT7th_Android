package com.example.kuit7_android.ui.components

import android.R.attr.height
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.Gray300
import com.example.kuit7_android.ui.theme.White

@Composable
fun KuitCard(
    modifier: Modifier = Modifier
        .fillMaxWidth(),

    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .border(2.dp, Gray300, RoundedCornerShape(15.dp)),
            //.size(width, height),
        color = White,
    ) {
        Box (
        contentAlignment = Alignment.Center
        ){
            content()
        }
    }
}