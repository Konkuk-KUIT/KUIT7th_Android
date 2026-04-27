package com.example.kuit7_android.ui.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.theme.MainBlue
import com.example.kuit7_android.ui.theme.Gray100
import com.example.kuit7_android.ui.theme.Gray300
import com.example.kuit7_android.ui.theme.Gray400

/**
 * [ProfileScreen]
 * 워크북의 학습 목표에 따라 설계된 프로필 화면입니다.
 * 1. 컴포넌트 단위로 나누어 설계 (공통 vs 내부)
 * 2. State Hoisting(상태 호이스팅) 적용: 설정 섹션의 스위치 상태를 최상위로 끌어올림
 * 3. LazyColumn을 사용하여 전체 스크롤 구조 구현
 */
@Composable
fun ProfileScreen() {
    // [상태 관리 - State Hoisting]
    // 하위 컴포넌트인 SettingsBox에서 사용될 상태를 부모인 ProfileScreen에서 관리합니다.
    var pushEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    val savedArticles = listOf(
        Article(R.drawable.img_article1, "Travel", "Her train broke down. Her phone died. And then she met her future husband", "", "1h ago", "CNN"),
        Article(R.drawable.img_article2, "Cuisine", "She discovered a hidden gem of a restaurant. The food was amazing!", "", "2h ago", "Foodie"),
        Article(R.drawable.img_article3, "Technology", "A new app promises to revolutionize communication in remote areas", "", "3h ago", "TechCrunch"),
        Article(R.drawable.img_article4, "Health", "Recent studies show the benefits of meditation on mental health", "", "4h ago", "Healthline")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // [내부 컴포넌트] 상단 로고 영역
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.kalar_logo),
                    contentDescription = "logo",
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // [내부 컴포넌트] 프로필 기본 정보
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "profile image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Gray100),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "홍길동",
                style = MaterialTheme.typography.titleLarge // M_20 적용
            )

            Spacer(modifier = Modifier.height(12.dp))

            // [공통 컴포넌트 성격] 프로필 수정 버튼
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = MainBlue),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.width(160.dp).height(40.dp)
            ) {
                Text(text = "프로필 수정", style = MaterialTheme.typography.bodyMedium, color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // [내부 컴포넌트] 프리미엄 플랜 섹션
            PremiumPlanCard()

            Spacer(modifier = Modifier.height(24.dp))

            // [내부 컴포넌트] 활동 통계 그리드
            StatisticsGrid()

            Spacer(modifier = Modifier.height(24.dp))

            // [State Hoisting 적용] 설정 섹션
            // 부모에서 관리하는 상태와 상태를 바꾸는 람다 함수를 전달합니다.
            SettingsBox(
                pushEnabled = pushEnabled,
                onPushChanged = { pushEnabled = it },
                darkModeEnabled = darkModeEnabled,
                onDarkModeChanged = { darkModeEnabled = it }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // [공통 컴포넌트 성격] 섹션 타이틀
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "저장한 기사", style = MaterialTheme.typography.titleMedium)
                Text(text = "모두 보기", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // [내부 컴포넌트 리스트] 저장한 기사 항목들
        items(savedArticles) { article ->
            Box(modifier = Modifier.padding(horizontal = 24.dp)) {
                SavedArticleItem(article)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

/**
 * 프리미엄 플랜 정보를 보여주는 내부 컴포넌트
 */
@Composable
fun PremiumPlanCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Gray400)
            .padding(16.dp)
    ) {
        Text(text = "프리미엄 플랜", color = Color.White, style = MaterialTheme.typography.titleMedium)
        Text(text = "다음 결제일: 2026년 5월 1일", color = Color.White, style = MaterialTheme.typography.labelSmall)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "일간 사용량", color = Color.White, style = MaterialTheme.typography.labelSmall)
            Text(text = "87%", color = Color.White, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.Gray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.87f)
                    .height(8.dp)
                    .background(Color.Black)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.fillMaxWidth().height(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "구독 관리", color = Color.Black, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

/**
 * 2x2 통계 그리드를 구성하는 내부 컴포넌트
 */
@Composable
fun StatisticsGrid() {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            StatCard(icon = R.drawable.ic_home, value = "127", label = "개 기사 읽음", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            StatCard(icon = R.drawable.ic_etc, value = "4.8천", label = "포인트", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            StatCard(icon = R.drawable.bookmark, value = "54", label = "북마크", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            StatCard(icon = R.drawable.ic_etc, value = "76", label = "댓글 작성", modifier = Modifier.weight(1f))
        }
    }
}

/**
 * 개별 통계 수치를 보여주는 내부 컴포넌트 카드
 */
@Composable
fun StatCard(icon: Int, value: String, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(12.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(icon), contentDescription = null, modifier = Modifier.size(24.dp), tint = Gray400)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
    }
}

/**
 * 푸시 알림 및 다크 모드 설정을 관리하는 컴포넌트 (State Hoisting 적용)
 * UI 로직과 상태를 분리하여 재사용성과 테스트 용이성을 높임
 */
@Composable
fun SettingsBox(
    pushEnabled: Boolean,
    onPushChanged: (Boolean) -> Unit,
    darkModeEnabled: Boolean,
    onDarkModeChanged: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "푸시 알림", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = pushEnabled,
                onCheckedChange = onPushChanged,
                colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = MainBlue)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "다크 모드", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = darkModeEnabled,
                onCheckedChange = onDarkModeChanged,
                colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = MainBlue)
            )
        }
    }
}

/**
 * 저장된 기사 리스트의 개별 아이템을 보여주는 내부 컴포넌트
 */
@Composable
fun SavedArticleItem(article: Article) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(article.image),
            contentDescription = null,
            modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = article.category, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            Text(text = article.title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, maxLines = 2)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.ic_bbc), contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = article.newspaper, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(painter = painterResource(R.drawable.ic_clock), contentDescription = null, modifier = Modifier.size(12.dp), tint = Color.Gray)
                Text(text = article.time, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
