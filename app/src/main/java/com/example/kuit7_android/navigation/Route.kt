package com.example.kuit7_android.navigation

sealed interface Route {
    val route: String

    data object HOME : Route {
        override val route = "home"
    }

    data object CONTACT : Route {
        override val route = "contact"
    }
    data object CONTACT_DETAIL : Route {
        override val route = "contact_detail"
    }

    //미션: 상세화면 추가
    // 변경한 부분: 기사 상세 화면(4번 화면) 라우트 추가
    data object HOME_DETAIL : Route {
        override val route = "home_detail"
    }
}