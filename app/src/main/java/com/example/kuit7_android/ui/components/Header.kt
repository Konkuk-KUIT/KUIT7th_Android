package com.example.kuit7_android.ui.components

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.R

@Composable
fun Header(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 8.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = "logo",
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable{
                    navController.popBackStack()
                }
        )
        Icon(
            painter = painterResource(R.drawable.kalar_logo),
            contentDescription = "logo",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}