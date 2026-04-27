package com.example.kuit7_android.navigation

import com.example.kuit7_android.R

/**
 * NavTab: 하단 네비게이션 바의 각 탭 정보를 정의하는 Enum 클래스입니다.
 * 각 탭은 아이콘 리소스, 이름(라벨), 그리고 이동할 경로(Route) 정보를 가집니다.
 */
enum class NavTab (
    val icon: Int,
    val label: String,
    val route: Route
){
    HOME(
        icon = R.drawable.ic_home,
        label = "Home",
        route = Route.HOME
    ),
    EXPLORE(
        icon = R.drawable.explore,
        label = "Explore",
        route = Route.EXPLORE
    ),
    BOOKMARK(
        icon = R.drawable.bookmark,
        label = "Bookmark",
        route = Route.BOOKMARK
    ),
    PROFILE(
        icon = R.drawable.profile,
        label = "Profile",
        route = Route.PROFILE
    )
}
