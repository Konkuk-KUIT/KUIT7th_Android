package com.example.kuit7_android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object KuitTheme {
    val typography: KuitTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalKuitTypography.current
}

@Composable
fun KUIT7_AndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // 현재는 Light Theme만 요구사항에 있으나, 추후 확장 가능
    val colorScheme = LightColorScheme
    val typography = KuitTypography()

    CompositionLocalProvider(
        LocalKuitTypography provides typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            // MaterialTheme의 기본 타이포그래피도 필요하다면 여기서 매핑 가능
            content = content
        )
    }
}