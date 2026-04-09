package com.example.kuit7_android.ui.profile.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.components.ArticleCard
import com.example.kuit7_android.ui.profile.component.HistoryCard
import com.example.kuit7_android.ui.components.MainTopBar
import com.example.kuit7_android.ui.profile.component.ProfileCard
import com.example.kuit7_android.ui.profile.component.Setting
import com.example.kuit7_android.ui.components.SmallTitle
import com.example.kuit7_android.ui.profile.component.SubscribeCard
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 23.dp)
    ) {
        item {
            MainTopBar()
            Spacer(Modifier.height(66.dp))
        }
        item {
            ProfileCard(
                userName = "홍길동",
                profileImage = R.drawable.pfimg1,
                pftextColor = KuitTheme.colors.gray900,
                pftextstyle = KuitTheme.typography.B_24,
                onClick = { println("구현x") },
                buttonName = "프로필 수정",
                bgColor = KuitTheme.colors.main,
                mbtextColor = KuitTheme.colors.white,
                mbtextstyle = KuitTheme.typography.M_16,
                width = 150.dp,
                height = 45.dp
            )
            Spacer(Modifier.height(54.dp))
        }
        item {
            SubscribeCard(
                usage = 87,
                barColor = KuitTheme.colors.gray900,
                usageColor = KuitTheme.colors.gray200,
                mutextstyle = KuitTheme.typography.R_12,
                mutextcolor = KuitTheme.colors.white,
                onClick = { println("구현안됨") },
                buttonName = "구독 관리",
                bgColor = KuitTheme.colors.white,
                mbtextColor = KuitTheme.colors.gray900,
                mbtextstyle = KuitTheme.typography.R_13,
                width = 280.dp,
                height = 35.dp,
            )
            Spacer(Modifier.height(43.dp))
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(34.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    HistoryCard(
                        icon = R.drawable.hic1,
                        mainText = "127",
                        subText = "개 기사 읽음"
                    )
                    Spacer(Modifier.width(34.dp))
                    HistoryCard(
                        icon = R.drawable.hic2,
                        mainText = "4.8천",
                        subText = "포인트"
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    HistoryCard(
                        icon = R.drawable.hic3,
                        mainText = "54",
                        subText = "북마크"
                    )
                    Spacer(Modifier.width(34.dp))
                    HistoryCard(
                        icon = R.drawable.hic4,
                        mainText = "76",
                        subText = "댓글 작성"
                    )
                }
            }
            Spacer(Modifier.height(30.dp))
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = KuitTheme.colors.gray300,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(25.dp)
            ) {
                Setting(
                    settingName = "푸시 알림",
                    isSelected = true
                )
                Spacer(Modifier.height(14.dp))
                Setting(
                    settingName = "다크 모드",
                    isSelected = false
                )
            }
            Spacer(Modifier.height(16.dp))
        }
        item {
            SmallTitle(
                titleText = "저장한 기사",
                seeAll = true
            )
            Spacer(Modifier.height(14.dp))
        }
        val articles = listOf<Article>(
            Article(
                image = R.drawable.img_article1,
                category = "Europe",
                title = "Ukraine's President Zelensky to BBC: Blood money being paid for Russian oil",
                content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
                time = "14m",
                newspaper = "BBC News"
            ),
            Article(
                image = R.drawable.img_article2,
                category = "Travel",
                title = "Her train broke down. Her phone died. And then she met her future husband",
                content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
                time = "1h",
                newspaper = "CNN"
            ),
            Article(
                image = R.drawable.img_article3,
                category = "Europe",
                title = "Russian warship: Moskva sinks in Black Sea",
                content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
                time = "4h",
                newspaper = "BBC News"
            ),
            Article(
                image = R.drawable.img_article4,
                category = "Money",
                title = "Wind power produced more electricity than coal and nuclear sources for first time every",
                content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
                time = "4h",
                newspaper = "USA Today"
            ),
            Article(
                image = R.drawable.img_article5,
                category = "Life",
                title = "'We keep rising to new challenges:' For churches hit by",
                content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
                time = "4h",
                newspaper = "USA Today"
            ),
        )
        items(articles) { article ->
            ArticleCard(
                article = article
            )
            Spacer(Modifier.height(14.dp))
        }

    }
}