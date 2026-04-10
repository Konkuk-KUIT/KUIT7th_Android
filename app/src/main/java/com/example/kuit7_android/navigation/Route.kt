package com.example.kuit7_android.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    val route: String

    data object HOME : Route {
        override val route = "home"
    }

    data object CONTACT : Route {
        override val route = "contact"
    }
    data object PROFILE : Route {
        override val route = "profile"
    }
}

