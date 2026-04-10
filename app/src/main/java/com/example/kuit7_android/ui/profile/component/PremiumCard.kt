package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.Gray400
import com.example.kuit7_android.ui.theme.KuitTheme

// 프로필 화면 구독 플랜 카드
// planName · nextBillingDate · usagePercent를 받아 표시
@Composable
fun PremiumCard(
    planName: String,
    nextBillingDate: String,
    usagePercent: Float  // 0f ~ 1f
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF8A9BB5))
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Column {
            // 플랜 이름
            Text(
                text = planName,
                style = KuitTheme.typography.B_16,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(13.dp))
            // 다음 결제일
            Text(
                text = "다음 결제일: $nextBillingDate",
                style = KuitTheme.typography.R_14,
                color = KuitTheme.colors.gray400
            )
            Spacer(modifier = Modifier.height(30.dp))

            // 사용량 라벨 + 퍼센트 수치
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "월간 사용량",
                    style = KuitTheme.typography.R_12,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "${(usagePercent * 100).toInt()}%",
                    style = KuitTheme.typography.R_12,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(6.dp))

            // 프로그레스 바 (배경 + 채움)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(Color(0xFF1F1F1F))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(usagePercent)
                        .height(10.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color(0xFFB0BEC5))
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            // 구독 관리 버튼
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "구독 관리",
                    style = KuitTheme.typography.M_16,
                    color = KuitTheme.colors.gray900
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PremiumCardPreview() {
    PremiumCard(
        planName = "프리미엄 플랜",
        nextBillingDate = "2026년 5월 1일",
        usagePercent = 0.87f
    )
}
