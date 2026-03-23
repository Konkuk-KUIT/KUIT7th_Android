package com.example.kuit7_android.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ToggleTextRow() {
    var selected by remember { mutableStateOf("latest") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Latest",
            fontSize = 16.sp,
            fontWeight = if (selected == "latest") FontWeight.Bold else FontWeight.Light,
            modifier = Modifier
                .clickable { selected = "latest" }
        )

        Text(
            text = "See all",
            fontSize = 16.sp,
            fontWeight = if (selected == "seeAll") FontWeight.Bold else FontWeight.Light,
            modifier = Modifier
                .clickable { selected = "seeAll" }
        )
    }
}