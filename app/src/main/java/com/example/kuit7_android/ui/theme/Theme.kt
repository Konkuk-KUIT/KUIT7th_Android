package com.example.kuit7_android.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun KUIT7_AndroidTheme(
    colors: KuitColors = KuitTheme.colors,
    typography: KuitTypography = KuitTheme.typography,
    darkColors: KuitColors?=null,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val currentColor=remember{if(darkColors!=null && darkTheme) darkColors else colors}

    val remeberedColors=remember{currentColor.copy()}.apply{update(other=currentColor)}


    CompositionLocalProvider(
        LocalColors provides remeberedColors,
        LocalTypography provides typography
    ){
        ProvideTextstyle(value=typography.R_16,content=content)
    }
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun ProvideTextstyle(value: TextStyle, content: @Composable (() -> Unit)) {
    content()
}

val LocalColors = staticCompositionLocalOf { lightColors() }


val LocalTypography = staticCompositionLocalOf { KuitTypography() }

object KuitTheme {
    val colors:KuitColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
    val typography:KuitTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current


}
