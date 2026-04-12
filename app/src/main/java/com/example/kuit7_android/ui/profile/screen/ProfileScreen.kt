package com.example.kuit7_android.ui.profile.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R
import com.example.kuit7_android.data.StatData
import com.example.kuit7_android.data.ToggleItemData
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.profile.component.ArticleCard
import com.example.kuit7_android.ui.profile.component.MainHeader
import com.example.kuit7_android.ui.profile.component.PremiumCard
import com.example.kuit7_android.ui.profile.component.ProfileSection
import com.example.kuit7_android.ui.profile.component.SmallTitleRow
import com.example.kuit7_android.ui.profile.component.StatCard
import com.example.kuit7_android.ui.profile.component.ToggleSection
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val mockStats = listOf(
        StatData(
            id = "article",
            resId = R.drawable.ic_article,
            count = "127",
            description = "개 기사 읽음",
        ),
        StatData(
            id = "award",
            resId = R.drawable.ic_award,
            count = "4.8천",
            description = "포인트"
        ),
        StatData(
            id = "bookmark",
            resId = R.drawable.ic_bookmark,
            count = "54",
            description = "북마크"
        ),
        StatData(
            id = "comment",
            resId = R.drawable.ic_comment,
            count = "76",
            description = "댓글 작성"
        )
    )

    var isPushChecked by remember { mutableStateOf(false) }
    var isDarkModeChecked by remember { mutableStateOf(false) }

    val mockArticles = listOf<Article>(
        Article(
            image = R.drawable.img_article2,
            category = "Travel",
            title = "Her train broke down. Her phone died. And then...",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "1h ago",
            newspaper = "CNN"
        ),
        Article(
            image = R.drawable.img_article2,
            category = "Cuisine",
            title = "She discovered a hidden gem of a resaurant. The ...",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "2h ago",
            newspaper = "Foodie"
        ),
        Article(
            image = R.drawable.img_article2,
            category = "Technology",
            title = "A new app promises to revolutionize commu...",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "3h ago",
            newspaper = "TechCrunch"
        ),
        Article(
            image = R.drawable.img_article2,
            category = "Health",
            title = "Recent studies show the benefits of meditation...",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "4h ago",
            newspaper = "Healthiline"
        ),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 23.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MainHeader()
            Spacer(Modifier.height(47.dp))
        }

        item {
            ProfileSection()
            Spacer(Modifier.height(47.dp))
        }

        item {
            PremiumCard(
                color = KuitTheme.colors.gray300,
                percentage = 0.87f
            )
            Spacer(Modifier.height(36.dp))
        }

        items(mockStats.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (stat in rowItems) {
                    StatCard(
                        id = stat.id,
                        resId = stat.resId,
                        count = stat.count,
                        description = stat.description,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(Modifier.height(34.dp))
        }

        item {
            val toggles = listOf(
                ToggleItemData("푸시 알림", isPushChecked) { isPushChecked = it },
                ToggleItemData("다크 모드", isDarkModeChecked) { isDarkModeChecked = it }
            )

            ToggleSection(items = toggles)
            Spacer(Modifier.height(20.dp))
        }

        item {
            SmallTitleRow()
        }

        items(mockArticles) { article ->
            ArticleCard(article)
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview(modifier: Modifier = Modifier) {
    ProfileScreen()
}