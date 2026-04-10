package com.example.kuit7_android.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Primitive Colors
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val MainBlue = Color(0xFF1877F2)
val Gray100 = Color(0xFFF3F4F6)
val Gray200 = Color(0xFFBDBDBD)
val Gray300 = Color(0xFF939DA9)
val Gray400 = Color(0xFF4E4B66)
val Gray900 = Color(0xFF1F1F1F)
val ErrorRed = Color(0xFFFA0C0C)

// Material 3 Color Scheme Mapping
val LightColorScheme = lightColorScheme(
    primary = MainBlue,           // 앱의 주요 색상
    onPrimary = White,            // 주요 색상 위의 텍스트/아이콘
    background = White,           // 앱 배경색
    onBackground = Gray900,       // 배경 위 기본 텍스트
    surface = White,              // 카드, 시트 등의 표면 색상
    onSurface = Gray900,          // 표면 위 텍스트
    surfaceVariant = Gray100,     // 보조적인 표면 색상 (입력창 등)
    onSurfaceVariant = Gray400,   // 보조 표면 위 텍스트
    outline = Gray200,            // 경계선/구분선
    error = ErrorRed,             // 에러 색상
    onError = White               // 에러 색상 위 텍스트
)