package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kuit7_android.R

@Composable
fun MainHeader(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(R.drawable.kalar_logo),
            contentDescription = "logo",
            modifier = Modifier.align(Alignment.Center),
            tint = Color.Unspecified
        )
    }
}

@Preview
@Composable
fun MainHeaderPreview(modifier: Modifier = Modifier) {
    MainHeader()
}