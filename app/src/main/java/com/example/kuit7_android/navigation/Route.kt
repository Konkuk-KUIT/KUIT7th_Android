package com.example.kuit7_android.navigation

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

    data object CONTACT_DETAIL : Route {
        override val route = "contact_detail"
    }

    data object HOME_DETAIL : Route {
        override val route = "home_detail"
    }
}