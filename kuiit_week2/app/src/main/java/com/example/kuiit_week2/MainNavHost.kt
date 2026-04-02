package com.example.kuiit_week2

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kuiit_week2.ui.theme.ContactDetailScreen

@Composable
fun MainNavHost(
    padding: PaddingValues,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.HOME.route,
        modifier = Modifier.padding(paddingValues = padding)
    ) {
        composable(Route.HOME.route) {
            HomeScreen()
        }
        composable(Route.CONTACT.route) {
            ContactScreen(navController = navController)
        }
        composable(Route.CONTACT_DETAIL.route) {
            ContactDetailScreen(
                navController = navController,
                call = Call(
                    image =1,
                    name = "박서연",
                    phone = "010-1234-5678"
                )
            )
        }

    }
}
