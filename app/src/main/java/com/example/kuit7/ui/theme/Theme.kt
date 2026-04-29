package com.example.kuit7.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

object KUIT7_AndroidTheme {
    val colors: KuitColors
        @Composable
        get() = LocalColors.current

    val typography: KuitTypography
        @Composable
        get() = LocalTypography.current
}

@Composable
fun KUIT7_AndroidTheme(
    colors: KuitColors,
    typography: KuitTypography,
    darkColors: KuitColors? = null,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val currentColor = remember { if (darkColors != null && darkTheme) darkColors else colors }

    val rememberedColors = remember { currentColor.copy() }.apply { update(other = currentColor) }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography
    ) {
        ProvideTextStyle(value = typography.R_16, content = content)
    }
}

val LocalColors = staticCompositionLocalOf { lightColors() }
val LocalTypography = staticCompositionLocalOf { KuitTypography() }