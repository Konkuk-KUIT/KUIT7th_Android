package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
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

@Composable
fun StatCard(
    id: String,
    resId: Int,
    count: String,
    description: String,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = Modifier
            .size(140.dp),
        border = BorderStroke(2.dp, color = KuitTheme.colors.gray300),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(resId),
                contentDescription = id
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(count, color = KuitTheme.colors.gray900, style = KuitTheme.typography.B_24)
            Spacer(modifier = Modifier.height(10.dp))
            Text(description, color = KuitTheme.colors.gray400, style = KuitTheme.typography.R_12)
        }
    }
}

@Preview
@Composable
fun StatCardPreview(modifier: Modifier = Modifier) {
    StatCard(
        id = "article",
        resId = R.drawable.ic_article,
        count = "127",
        description = "개 기사 읽음"
    )
}