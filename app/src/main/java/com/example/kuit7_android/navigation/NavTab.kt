package com.example.kuit7_android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import com.example.kuit7_android.R

enum class NavTab (
    val icon: Int,
    val label: String,
    val route: Route
){
    HOME(
        icon = R.drawable.ic_home,
        label = "홈",
        route = Route.HOME
    ),
    CONTACT(
        icon = R.drawable.ic_contact,
        label = "연락처",
        route = Route.CONTACT
    ),
    PROFILE(
        icon = R.drawable.ic_profile,
        label = "프로필",
        route = Route.PROFILE
    )

}