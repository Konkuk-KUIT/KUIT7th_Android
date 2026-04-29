package com.example.kuit7_android.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryRow() {
    val categories = listOf(
        "All", "Sports", "Politics", "Business", "Health", "Travel", "Science"
    )

    var selected by remember { mutableStateOf("All") }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        items(categories) { category ->
            Text(
                text = category,
                fontSize = 14.sp,
                fontWeight = if (selected == category) FontWeight.Bold else FontWeight.Light,
                color = if (selected == category) Color.Black else Color.Gray,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable { selected = category }
            )
        }
    }
}