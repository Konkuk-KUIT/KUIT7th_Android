package com.example.kuit7_android.ui.Profile.screen

import SubscriptionCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.Profile.component.DashboardGrid
import com.example.kuit7_android.ui.Profile.component.SavedArticlesSection
import com.example.kuit7_android.ui.Profile.component.SettingsSection
import com.example.kuit7_android.ui.Profile.component.TopProfileSection

@Composable
fun ProfileScreen() {
    // Scaffold를 사용하면 하단 네비게이션 바 등과 조합하기 좋습니다.
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // 기존에 만드신 하단 탭 바가 있다면 여기에 배치하세요.
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White), // 전체 배경색 설정
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. 최상단 프로필 섹션 (App Logo, Image, Name, Button)
            item {
                TopProfileSection()
            }

            // 2. 프리미엄 구독 카드 섹션
            item {
                SubscriptionCard()
            }

            // 3. 데이터 대시보드 (4개 그리드 아이템)
            item {
                DashboardGrid()
            }

            // 4. 설정 섹션 (푸시 알림, 다크 모드)
            item {
                SettingsSection()
            }

            // 5. 저장된 기사 섹션 (헤더 + 리스트)
            // SavedArticleSection 내부에 ArticleCard들이 포함되어 있다면 바로 호출
            item {
                SavedArticlesSection()
            }

            // 리스트 하단에 여유 공간 추가
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
@Preview
@Composable
fun ProfileScreenPreview(modifier: Modifier = Modifier) {
    ProfileScreen()
}