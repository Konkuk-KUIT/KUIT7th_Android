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
import com.example.kuit7_android.ui.profile.screen.ProfileScreen

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
        composable(Route.HOME.route) {
            HomeScreen(navController = navController)
        }

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

        composable(Route.CONTACT.route) {
            ContactScreen(navController = navController)
        }

        composable(Route.CONTACT_DETAIL.route) {
            val call = navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<Call>("call")

            call?.let {
                ContactDetailScreen(
                    call = it,
                    navController = navController
                )
            }
        }

        composable(Route.PROFILE.route) {
            ProfileScreen()
        }
    }
}