package com.example.kuit7_android.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.kuit7_android.ui.contact.screen.ContactScreen
import com.example.kuit7_android.ui.home.screen.HomeScreen
import com.example.kuit7_android.ui.contact.screen.ContactDetailScreen
import com.example.kuit7_android.ui.home.screen.HomeDetailScreen
import com.example.kuit7_android.ui.contact.Call
import com.example.kuit7_android.ui.home.Article

/**
 * MainNavHost: 앱의 화면 전환(Navigation)을 정의하는 공간입니다.
 * NavHost를 통해 어떤 경로(Route)일 때 어떤 화면(Composable)을 보여줄지 결정합니다.
 */
@Composable
fun MainNavHost(
    padding: PaddingValues, // Scaffold에서 전달받은 여백 정보
    navController: NavHostController // 화면 이동을 제어하는 컨트롤러
) {
    NavHost(
        navController = navController,
        startDestination = Route.HOME.route, // 앱 시작 시 처음 보여줄 화면 (홈)
        modifier = Modifier.padding(padding) // 하단바 영역만큼 여백 부여
    ) {
        // 1. 홈 화면 경로 설정
        composable(Route.HOME.route) {
            HomeScreen(navController = navController)
        }

        // 2. 연락처 화면 경로 설정
        composable(Route.CONTACT.route) {
            ContactScreen(navController = navController)
        }

        // 3. 연락처 상세 화면 경로 설정
        composable(Route.CONTACT_DETAIL.route) {
            // 이전 화면에서 savedStateHandle에 저장해둔 데이터를 꺼내옵니다.
            val call = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Call>("call")

            call?.let {
                ContactDetailScreen(
                    call = it,
                    navController = navController
                )
            }
        }

        // 4. 뉴스 상세 화면 경로 설정
        composable(Route.HOME_DETAIL.route) {
            // 이전 화면에서 전달받은 기사(Article) 데이터를 꺼내옵니다.
            val article = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Article>("article")

            article?.let {
                HomeDetailScreen(
                    article = it,
                    navController = navController
                )
            }
        }
    }
}
