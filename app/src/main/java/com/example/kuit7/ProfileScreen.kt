package com.example.kuit7

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7.ui.theme.KUIT7_AndroidTheme

// ─── 프로필 화면 전체 ───
@Composable
fun ProfileScreen(
    isPushEnabled: Boolean,
    onPushToggle: (Boolean) -> Unit,
    isDarkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit,
    articles: List<NewsArticle>,
    onArticleClick: (NewsArticle) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // AppLogo
        Image(
            painter = painterResource(id = R.drawable.kaar_logo),
            contentDescription = "Kabar",
            modifier = Modifier
                .height(40.dp)
                .padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProfileSection(onEditClick = { /* TODO */ })

        Spacer(modifier = Modifier.height(24.dp))

        SubscriptionCard(onManageClick = { /* TODO */ })

        Spacer(modifier = Modifier.height(24.dp))

        DataDashboard()

        Spacer(modifier = Modifier.height(24.dp))

        ThemeBox(
            isPushEnabled = isPushEnabled,
            onPushToggle = onPushToggle,
            isDarkMode = isDarkMode,
            onDarkModeToggle = onDarkModeToggle
        )

        Spacer(modifier = Modifier.height(24.dp))

        SavedArticlesSection(
            articles = articles,
            onArticleClick = onArticleClick,
            onSeeAllClick = { /* TODO */ }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

// ─── ProfileSection ───
@Composable
private fun ProfileSection(
    onEditClick: () -> Unit
) {
    val colors = KUIT7_AndroidTheme.colors
    val typography = KUIT7_AndroidTheme.typography

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.phone1),
            contentDescription = "프로필 이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "홍길동",
            style = typography.M_20,
            color = colors.gray900
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onEditClick,
            colors = ButtonDefaults.buttonColors(containerColor = colors.main),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                "프로필 수정",
                style = typography.R_14,
                color = colors.white
            )
        }
    }
}

// ─── SubscriptionCard ───
@Composable
private fun SubscriptionCard(
    onManageClick: () -> Unit
) {
    val colors = KUIT7_AndroidTheme.colors
    val typography = KUIT7_AndroidTheme.typography

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = colors.gray100)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "프리미엄 플랜",
                style = typography.M_20,
                color = colors.gray900
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "다음 결제일: 2026년 5월 1일",
                style = typography.R_14,
                color = colors.gray300
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "월간 사용량",
                    style = typography.R_14,
                    color = colors.gray400
                )
                Text(
                    text = "87%",
                    style = typography.B_13,
                    color = colors.gray900
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { 0.87f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = colors.gray900,
                trackColor = colors.gray200,
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = onManageClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "구독 관리",
                    style = typography.M_16,
                    color = colors.gray900
                )
            }
        }
    }
}

// ─── DataDashboard (Column → Row + Row) ───
@Composable
private fun DataDashboard() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(icon = "📰", value = "127", label = "개 기사 읽음", modifier = Modifier.weight(1f))
            StatCard(icon = "⚙️", value = "4.8천", label = "포인트", modifier = Modifier.weight(1f))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(icon = "🔖", value = "54", label = "북마크", modifier = Modifier.weight(1f))
            StatCard(icon = "💬", value = "76", label = "댓글 작성", modifier = Modifier.weight(1f))
        }
    }
}

// ─── StatCard (공통 컴포넌트) ───
@Composable
private fun StatCard(
    icon: String,
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    val colors = KUIT7_AndroidTheme.colors
    val typography = KUIT7_AndroidTheme.typography

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = colors.gray100)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = icon, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                style = typography.B_24,
                color = colors.gray900
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                style = typography.R_14,
                color = colors.gray300
            )
        }
    }
}

// ─── ThemeBox (Column) ───
@Composable
private fun ThemeBox(
    isPushEnabled: Boolean,
    onPushToggle: (Boolean) -> Unit,
    isDarkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit
) {
    val colors = KUIT7_AndroidTheme.colors

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = colors.gray100)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ThemeBinaryRow(
                label = "푸시 알림",
                checked = isPushEnabled,
                onCheckedChange = onPushToggle
            )

            Spacer(modifier = Modifier.height(8.dp))

            ThemeBinaryRow(
                label = "다크 모드",
                checked = isDarkMode,
                onCheckedChange = onDarkModeToggle
            )
        }
    }
}

// ─── ThemeBinaryRow (공통 컴포넌트) ───
@Composable
private fun ThemeBinaryRow(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val colors = KUIT7_AndroidTheme.colors
    val typography = KUIT7_AndroidTheme.typography

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = typography.M_16,
            color = colors.gray900
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = colors.white,
                checkedTrackColor = colors.main,
                uncheckedThumbColor = colors.white,
                uncheckedTrackColor = colors.gray200
            )
        )
    }
}

// ─── SavedArticlesSection (Column) ───
@Composable
private fun SavedArticlesSection(
    articles: List<NewsArticle>,
    onArticleClick: (NewsArticle) -> Unit,
    onSeeAllClick: () -> Unit
) {
    val colors = KUIT7_AndroidTheme.colors
    val typography = KUIT7_AndroidTheme.typography

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "저장한 기사",
                style = typography.M_20,
                color = colors.gray900
            )
            Text(
                text = "모두 보기",
                style = typography.R_14,
                color = colors.main,
                modifier = Modifier.clickable { onSeeAllClick() }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        articles.forEach { article ->
            NewsArticleCard(
                article = article,
                onClick = { onArticleClick(article) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}