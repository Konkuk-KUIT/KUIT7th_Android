package com.example.kuit7_android.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kuit7_android.ui.contact.Call
import com.example.kuit7_android.ui.contact.screen.ContactDetailScreen

import com.example.kuit7_android.ui.contact.screen.ContactScreen
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.home.screen.HomeDetailScreen
import com.example.kuit7_android.ui.home.screen.HomeScreen

@Composable
fun MainNavHost(
    padding: PaddingValues,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.HOME.route,
        modifier = Modifier.padding(padding)
    ) {
        // 변경한 부분: HomeScreen에 navController 인자 추가 (기사 클릭 시 상세 화면 이동 위해)
        composable(Route.HOME.route) {
            HomeScreen(navController = navController)
        }

        composable(Route.CONTACT.route) {
            ContactScreen(navController = navController)
        }
        composable(Route.CONTACT_DETAIL.route){
            val call = navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<Call>("call")

            call?.let{
                ContactDetailScreen(call = it,
                    navController = navController)
            }
        }
        //미션: composable 추가
        //설명: 각 화면 인자에 devcontrol 접목하여 뒤로가기 구현
        // 변경한 부분: 기사 상세 화면(4번 화면) composable 추가
        // 설명: ContactDetail과 동일한 방식으로 savedStateHandle에서 Article 꺼내 HomeDetailScreen 호출
        composable(Route.HOME_DETAIL.route) {
            val article = navController
                .previousBackStackEntry
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