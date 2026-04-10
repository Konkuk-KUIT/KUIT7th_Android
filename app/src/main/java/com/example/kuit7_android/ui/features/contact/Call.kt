package com.example.kuit7_android.ui.features.contact

import kotlinx.serialization.Serializable

@Serializable
data class Call(
    val image: Int,
    val name: String,
    val phone: String
)
