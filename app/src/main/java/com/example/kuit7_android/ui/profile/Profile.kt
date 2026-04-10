package com.example.kuit7_android.ui.profile

// Profile.java를 대체하는 Kotlin data class
// 사용자 프로필 정보를 담는 모델
data class Profile(
    val name: String,
    val articlesRead: Int,
    val points: String,
    val bookmarks: Int,
    val comments: Int,
    val planName: String,
    val nextBillingDate: String,
    val usagePercent: Float
)
