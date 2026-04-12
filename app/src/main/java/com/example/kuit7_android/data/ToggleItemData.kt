package com.example.kuit7_android.data

data class ToggleItemData(
    val label: String,
    val isChecked: Boolean,
    val onToggleChanged: (Boolean) -> Unit
)