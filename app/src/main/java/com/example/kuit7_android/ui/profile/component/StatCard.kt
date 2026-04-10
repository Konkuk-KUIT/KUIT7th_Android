package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.theme.KuitTheme

// 프로필 화면에서 사용하는 재사용 통계 카드
// 아이콘 · 숫자값 · 라벨을 수직 배치
@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    iconRes: Int,
    value: String,
    label: String
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = label,
            modifier = Modifier.size(18.dp),
            tint = KuitTheme.colors.gray900
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
            style = KuitTheme.typography.B_24,
            color = KuitTheme.colors.gray900
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = KuitTheme.typography.R_12,
            color = KuitTheme.colors.gray400
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StatCardPreview() {
    StatCard(
        iconRes = R.drawable.ic_bookmark,
        value = "54",
        label = "북마크"
    )
}
