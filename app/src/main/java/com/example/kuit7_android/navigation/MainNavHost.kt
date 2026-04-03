package com.example.kuit7_android.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

import com.example.kuit7_android.ui.contact.screen.ContactScreen
import com.example.kuit7_android.ui.contactDetail.screen.ContactDetailScreen
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.contact.Call
import com.example.kuit7_android.ui.home.screen.HomeScreen
import com.example.kuit7_android.ui.homeDetail.screen.HomeDetailScreen

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
            HomeScreen(navController)
        }

        composable(Route.CONTACT.route) {
            ContactScreen(navController)
        }
        composable<Article> { backStackEntry ->
            val route = backStackEntry.toRoute<Article>()
            HomeDetailScreen(navController, article = route)
        }
        composable<Call> {backStackEntry ->
            val route = backStackEntry.toRoute<Call>()
            ContactDetailScreen(navController, contact = route)
        }
    }
}