package com.example.kuit7_android.ui.features.homeDetail.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R

@Composable
fun Header(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 8.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = "logo",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Icon(
            painter = painterResource(R.drawable.kalar_logo),
            contentDescription = "logo",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun HdPrev() {
    Header()
}