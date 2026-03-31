package com.example.kuit7_android.ui.home

import java.io.Serializable

// 변경한 부분: Article을 Serializable로 변경 (NavController savedStateHandle로 전달하기 위해)
data class Article(
    val image: Int,
    val category: String,
    val title: String,
    val content: String,
    val time: String,
    val newspaper: String
) : Serializable
