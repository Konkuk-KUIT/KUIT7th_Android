package com.example.kuit7_android.ui.Profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.test.espresso.base.Default
import com.example.kuit7_android.R

@Composable
fun SavedArticlesSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("저장한 기사", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            TextButton(onClick = { /* 모두 보기 */ }) {
                Text("모두 보기", color = Color.Gray)
            }
        }

        // 실제 구현 시 items()를 사용하여 리스트 생성
        ArticleCard("Travel", "Her train broke down. Her phone died. And then...", "CNN", "1h ago")
        ArticleCard("Cuisine", "She discovered a hidden gem of a restaurant...", "Foodie", "2h ago")
    }
}

@Composable
fun ArticleCard(category: String, title: String, source: String, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Thumbnail Image
        Box(
            modifier = Modifier.size(96.dp).clip(RoundedCornerShape(12.dp)).background(Color.LightGray)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(category, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            Text(title, maxLines = 2, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                // 소스 로고 대신 아이콘/텍스트
                Text(source, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(painter = painterResource(id = R.drawable.ic_clock), contentDescription = null, modifier = Modifier.size(12.dp), tint = Color.Gray)
                Text(" $time", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
        }
    }
}

class Icons(
    accessTime: Any,
    contentDescription: Nothing?,
    modifier: Modifier,
    tint: Color
) {
    class   Default(icon: Any) : Any()

}
