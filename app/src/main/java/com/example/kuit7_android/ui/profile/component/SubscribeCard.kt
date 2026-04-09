package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.components.ModifyButton
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun SubscribeCard(
    usage: Int,
    barColor: Color,
    usageColor: Color,
    mutextstyle: TextStyle,
    mutextcolor: Color,
    onClick: () -> Unit,
    buttonName: String,
    bgColor: Color,
    mbtextColor: Color,
    mbtextstyle: TextStyle,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(KuitTheme.colors.gray300)
            .padding(16.dp)
    ) {
        Text(
            text = "프리미엄 플랜",
            style = KuitTheme.typography.B_16,
            color = KuitTheme.colors.white
        )
        Spacer(modifier = Modifier.height(13.dp))
        Text(
            text = "다음 결제일: 2026년 5월 1일",
            style = KuitTheme.typography.R_14,
            color = KuitTheme.colors.gray400
        )
        Spacer(Modifier.height(25.dp))
        MonthUsage(
            usage = usage,
            barColor = barColor,
            usageColor = usageColor,
            textstyle = mutextstyle,
            textcolor = mutextcolor
        )
        Spacer(Modifier.height(31.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ModifyButton(
                onClick = onClick,
                buttonName = buttonName,
                bgColor = bgColor,
                textstyle = mbtextstyle,
                textColor = mbtextColor,
                width = width,
                height = height
            )
        }
    }
}