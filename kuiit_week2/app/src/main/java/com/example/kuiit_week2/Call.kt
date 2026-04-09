package com.example.kuiit_week2

import java.io.Serializable

data class Call(
    val image: Int,
    val name: String,
    val phone: String
) : Serializable
