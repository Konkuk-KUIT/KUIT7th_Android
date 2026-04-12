package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun SmallTitleRow(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("저장한 기사", color = KuitTheme.colors.gray900, style = KuitTheme.typography.M_20)
        Column(
            modifier = modifier.clickable { },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "모두 보기",
                style = KuitTheme.typography.R_14, // 원하는 스타일 적용
                color = KuitTheme.colors.gray900
            )

            Spacer(modifier = Modifier.height(2.dp))

            Box(
                modifier = Modifier
                    .height(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun SmallTitleRowPreview(modifier: Modifier = Modifier) {
    SmallTitleRow()
}