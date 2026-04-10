package com.example.kuit7_android.ui.profile.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.profile.Profile
import com.example.kuit7_android.ui.profile.component.PremiumCard
import com.example.kuit7_android.ui.profile.component.SavedArticleItem
import com.example.kuit7_android.ui.profile.component.StatCard
import com.example.kuit7_android.ui.profile.component.ToggleSetting
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    // ── 더미 데이터 ──────────────────────────────────────────────
    val profile = Profile(
        name = "홍길동",
        articlesRead = 127,
        points = "4.8천",
        bookmarks = 54,
        comments = 76,
        planName = "프리미엄 플랜",
        nextBillingDate = "2026년 5월 1일",
        usagePercent = 0.87f
    )

    val savedArticles = listOf(
        Article(
            image = R.drawable.img_article2,
            category = "Travel",
            title = "Her train broke down. Her phone died. And then...",
            content = "",
            time = "1h ago",
            newspaper = "CNN"
        ),
        Article(
            image = R.drawable.img_article2,
            category = "Cuisine",
            title = "She discovered a hidden gem of a restaurant. The...",
            content = "",
            time = "2h ago",
            newspaper = "Foodie"
        ),
        Article(
            image = R.drawable.img_article2,
            category = "Technology",
            title = "A new app promises to revolutionize commu...",
            content = "",
            time = "3h ago",
            newspaper = "TechCrunch"
        ),
        Article(
            image = R.drawable.img_article2,
            category = "Health",
            title = "Recent studies show the benefits of meditation...",
            content = "",
            time = "4h ago",
            newspaper = "Healthline"
        )
    )

    // 신문사 이름 → 로고 drawable 매핑
    fun logoRes(newspaper: String): Int = when (newspaper) {
        "BBC News" -> R.drawable.ic_bbc
        "CNN"      -> R.drawable.ic_cnn
        "USA Today" -> R.drawable.ic_usa
        else       -> R.drawable.ic_cnn   // Foodie, TechCrunch, Healthline 등 기본값
    }

    // ── 토글 상태 ────────────────────────────────────────────────
    var pushNotification by remember { mutableStateOf(true) }
    var darkMode by remember { mutableStateOf(false) }

    // ── 전체 화면 LazyColumn ─────────────────────────────────────
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {

        // ① 로고 헤더
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.kalar_logo),
                    contentDescription = "logo",
                    tint = Color.Unspecified
                )
            }
        }

        // ② 아바타 + 이름 + 프로필 수정 버튼
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                // 아바타 원형
                Box(
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFD9D9D9)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_profile),
                        contentDescription = "avatar",
                        modifier = Modifier.size(52.dp),
                        tint = Color(0xFF9E9E9E)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                // 사용자 이름
                Text(
                    text = profile.name,
                    style = KuitTheme.typography.B_24,
                    color = KuitTheme.colors.gray900
                )
                Spacer(modifier = Modifier.height(12.dp))

                // 프로필 수정 버튼
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(45.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(KuitTheme.colors.main),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "프로필 수정",
                        style = KuitTheme.typography.M_16,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        // ③ 프리미엄 플랜 카드 (PremiumCard 컴포넌트)
        item {
            PremiumCard(
                planName = profile.planName,
                nextBillingDate = profile.nextBillingDate,
                usagePercent = profile.usagePercent
            )
            Spacer(modifier = Modifier.height(43.dp))
        }

        // ④ 통계 카드 2×2 그리드 (StatCard 컴포넌트 × 4)
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    modifier = Modifier.weight(1f),
                    iconRes = R.drawable.ic_article_read,
                    value = profile.articlesRead.toString(),
                    label = "개 기사 읽음"
                )
                StatCard(
                    modifier = Modifier.weight(1f),
                    iconRes = R.drawable.ic_star,
                    value = profile.points,
                    label = "포인트"
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    modifier = Modifier.weight(1f),
                    iconRes = R.drawable.ic_bookmark,
                    value = profile.bookmarks.toString(),
                    label = "북마크"
                )
                StatCard(
                    modifier = Modifier.weight(1f),
                    iconRes = R.drawable.ic_comment,
                    value = profile.comments.toString(),
                    label = "댓글 작성"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // ⑤ 토글 설정 카드 (ToggleSetting 컴포넌트)
        item {
            ToggleSetting(
                pushNotification = pushNotification,
                darkMode = darkMode,
                onPushNotificationChange = { pushNotification = it },
                onDarkModeChange = { darkMode = it }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        // ⑥ 저장한 기사 섹션 헤더
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "저장한 기사",
                    style = KuitTheme.typography.B_16,
                    color = KuitTheme.colors.gray900
                )
                Text(
                    text = "모두 보기",
                    style = KuitTheme.typography.R_14,
                    color = KuitTheme.colors.gray400,
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        // ⑦ 저장한 기사 목록 (SavedArticleItem 컴포넌트)
        items(savedArticles) { article ->
            SavedArticleItem(
                article = article,
                logoRes = logoRes(article.newspaper)
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}
