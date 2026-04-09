package com.example.kuit7_android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun SmallTitle(
    titleText: String,
    seeAll: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = titleText,
            style = KuitTheme.typography.M_20,
            color = KuitTheme.colors.gray900
        )
        if (seeAll) {
            Text(
                text = "모두 보기",
                style = KuitTheme.typography.R_14,
                color = KuitTheme.colors.gray900
            )
        } else {
        }
    }
}