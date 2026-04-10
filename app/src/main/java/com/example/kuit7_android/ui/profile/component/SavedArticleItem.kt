package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.theme.KuitTheme

// 저장한 기사 목록 한 행
// home.Article을 공유 데이터 모델로 사용
@Composable
fun SavedArticleItem(
    article: Article,
    logoRes: Int  // 신문사 로고 drawable
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(7.dp),
        verticalAlignment = Alignment.Top
    ) {
        // 썸네일
        Image(
            painter = painterResource(article.image),
            contentDescription = article.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            // 카테고리
            Text(
                text = article.category,
                style = KuitTheme.typography.R_12,
                color = Color(0xFF6B7280)
            )
            Spacer(modifier = Modifier.height(9.dp))
            // 제목 (최대 2줄)
            Text(
                text = article.title,
                style = KuitTheme.typography.R_16,
                color = KuitTheme.colors.gray900,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(9.dp))
            // 신문사 로고 + 이름 + 시간 + 더보기
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(logoRes),
                    contentDescription = article.newspaper,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = article.newspaper,
                    style = KuitTheme.typography.B_13,
                    color = Color(0xFF4D4A63)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_clock),
                    contentDescription = "time",
                    modifier = Modifier.size(13.dp),
                    tint = KuitTheme.colors.gray400
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = article.time,
                    style = KuitTheme.typography.R_13,
                    color = KuitTheme.colors.gray400,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.ic_etc),
                    contentDescription = "more",
                    modifier = Modifier.size(14.dp),
                    tint = KuitTheme.colors.gray300
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedArticleItemPreview() {
    SavedArticleItem(
        article = Article(
            image = R.drawable.img_article2,
            category = "Travel",
            title = "Her train broke down. Her phone died. And then...",
            content = "",
            time = "1h ago",
            newspaper = "CNN"
        ),
        logoRes = R.drawable.ic_cnn
    )
}
