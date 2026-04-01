package com.example.kuitweek2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable

@Composable
fun NewsScreen(modifier: Modifier = Modifier) {
    val categories = listOf("All", "Sports", "Politics", "Business", "Health", "Travel", "Science")
    var selectedCategory by remember { mutableStateOf("All") }

    val articles = listOf(
        NewsArticle(
            image = R.drawable.image1,
            category = "Europe",
            title = "Ukraine's President Zelensky to BBC: Blood money being paid...",
            source = "BBC News",
            sourceIcon = R.drawable.bbc_icon,
            time = "14m ago"
        ),
        NewsArticle(
            image = R.drawable.image2,
            category = "Travel",
            title = "Her train broke down. Her phone died. And then she met her..",
            source = "CNN",
            sourceIcon = R.drawable.cnn_icon,
            time = "1h ago"
        ),
        NewsArticle(
            image = R.drawable.image3,
            category = "Europe",
            title = "Russian warship: Moskva sinks in Black Sea",
            source = "BBC News",
            sourceIcon = R.drawable.bbc_icon,
            time = "4h ago"
        ),
        NewsArticle(
            image = R.drawable.image4,
            category = "Money",
            title = "Wind power produced more electricity than coal and nucle...",
            source = "USA Today",
            sourceIcon = R.drawable.usat_icon,
            time = "4h ago"
        ),
        NewsArticle(
            image = R.drawable.image5,
            category = "Life",
            title = "'We keep rising to new challenges:' For churches hit by...",
            source = "USA Today",
            sourceIcon = R.drawable.usat_icon,
            time = "4h ago"
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // 앱 로고 (이미지)
        Image(
            painter = painterResource(id = R.drawable.kaar_logo),
            contentDescription = "Kabar",
            modifier = Modifier
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Latest + See all
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Latest",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "See all",
                fontSize = 14.sp,
                color = Color(0xFF1877F2)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 카테고리 탭
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories) { category ->
                Text(
                    text = category,
                    fontSize = 16.sp,
                    fontWeight = if (selectedCategory == category) FontWeight.Bold else FontWeight.Normal,
                    color = if (selectedCategory == category) Color(0xFF1877F2) else Color.Gray,
                    modifier = Modifier
                        .clickable { selectedCategory = category }
                        .padding(vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 기사 리스트
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(articles) { article ->
                NewsArticleCard(article = article)
            }
        }
    }
}

@Composable
fun NewsArticleCard(article: NewsArticle) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        // 썸네일
        Image(
            painter = painterResource(id = article.image),
            contentDescription = article.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        // 기사 정보
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = article.category,
                fontSize = 13.sp,
                color = Color.Gray
            )

            Text(
                text = article.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 3
            )

// 출처 + 시간
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = article.sourceIcon),
                    contentDescription = article.source,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = article.source,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "time",
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = article.time,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        // 더보기
        Text(
            text = "···",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen()
}