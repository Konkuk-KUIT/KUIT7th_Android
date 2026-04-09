package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun Setting(
    settingName: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(26.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = settingName,
            style = KuitTheme.typography.M_16,
            color = KuitTheme.colors.gray900
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .width(56.dp)
                    .height(26.dp)
                    .background(color = KuitTheme.colors.main, shape = CircleShape)
                    .padding(horizontal = 4.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(color = KuitTheme.colors.white, shape = CircleShape)
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .width(56.dp)
                    .height(26.dp)
                    .background(color = KuitTheme.colors.gray200, shape = CircleShape)
                    .padding(horizontal = 4.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(color = KuitTheme.colors.white, shape = CircleShape)
                )
            }
        }
    }
}