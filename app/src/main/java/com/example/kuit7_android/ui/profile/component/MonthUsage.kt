package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun MonthUsage(
    usage: Int,
    barColor: Color,
    usageColor: Color,
    textstyle: TextStyle,
    textcolor: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "월간 사용량",
                style = textstyle,
                color = textcolor
            )
            Text(
                text = "${usage}%",
                style = textstyle,
                color = textcolor

            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        var usagef = usage / 100f
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .width(286.dp)
                .height(10.dp)
                .clip(CircleShape)
                .background(color = barColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(usagef)
                    .fillMaxHeight()
                    .clip(CircleShape)
                    .background(color = usageColor)
            )
        }
    }

}