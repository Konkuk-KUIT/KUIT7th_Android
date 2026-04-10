package com.example.kuit7_android.ui.features.ProfilePage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.components.ButtonWhite
import com.example.kuit7_android.ui.theme.Black
import com.example.kuit7_android.ui.theme.Gray200
import com.example.kuit7_android.ui.theme.Gray300
import com.example.kuit7_android.ui.theme.Gray400
import com.example.kuit7_android.ui.theme.KuitTheme
import com.example.kuit7_android.ui.theme.White

@Composable
fun PlanUsage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Gray300)
            .padding(14.dp, 16.dp)
    ) {
        Text(
            text = "프리미엄 플랜",
            style = KuitTheme.typography.B_16,
            color = White
        )
        Spacer(Modifier.height(13.dp))
        Text(
            text = "다음 결제일: 2026년 5월 1일",
            style = KuitTheme.typography.R_14,
            color = Gray400
        )
        Spacer(Modifier.height(30.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "월간 사용량",
                style = KuitTheme.typography.R_12,
                color = White
            )
            Text(
                text = "87%",
                style = KuitTheme.typography.R_12,
                color = White
            )
        }
        Spacer(Modifier.height(4.dp))
        LinearProgressIndicator(
            progress = {0.87f},
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp)), // 모서리 둥글게
            color = Gray200,        // 채워지는 색
            trackColor = Black // 바탕색
        )
        Spacer(Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){ButtonWhite("구독 관리")}
    }
}