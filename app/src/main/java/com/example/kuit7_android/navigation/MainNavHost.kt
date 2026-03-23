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
            HomeScreen()
        }

        composable(Route.CONTACT.route) {
            ContactScreen()
        }
    }
}