package com.example.kuit7_android.ui.features.contact.data

import com.example.kuit7_android.R
import com.example.kuit7_android.ui.features.contact.Call

object CallItem {
    val callList = listOf<Call>(
        Call(
            image = R.drawable.img_profile1,
            name = "박서연",
            phone = "010-1234-5678"
        ),
        Call(
            image = R.drawable.img_profile2,
            name = "김건국",
            phone = "010-1234-5678"
        ),
        Call(
            image = R.drawable.img_profile3,
            name = "홍길동",
            phone = "010-1234-5678"
        )
    )
}