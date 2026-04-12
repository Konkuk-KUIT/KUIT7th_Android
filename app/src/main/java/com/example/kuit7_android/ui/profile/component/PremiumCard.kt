package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun PremiumCard(
    color: Color,
    percentage: Float,
    modifier: Modifier = Modifier
) {
    val percentageToInt = (percentage * 100).toInt()

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text("프리미엄 플랜", color = KuitTheme.colors.white, style = KuitTheme.typography.B_16)

            Spacer(modifier = Modifier.height(13.dp))

            Text(
                "다음 결제일: 2026년 5월 1일",
                color = KuitTheme.colors.gray400,
                style = KuitTheme.typography.R_14
            )

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("월간 사용량", color = KuitTheme.colors.white, style = KuitTheme.typography.R_12)
                Text(
                    "$percentageToInt%",
                    color = KuitTheme.colors.white,
                    style = KuitTheme.typography.R_12
                )
            }

            LinearProgressIndicator(
                progress = { percentage },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = KuitTheme.colors.gray200,
                trackColor = KuitTheme.colors.gray900,
                strokeCap = StrokeCap.Round
            )

            Spacer(modifier = Modifier.height(30.dp))

            ButtonComponent(
                label = "구독 관리",
                color = KuitTheme.colors.white,
                font = KuitTheme.typography.R_13,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun PremiumCardPreview(modifier: Modifier = Modifier) {
    PremiumCard(color = KuitTheme.colors.gray300, percentage = 0.87f)
}