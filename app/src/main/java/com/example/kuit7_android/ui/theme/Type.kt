package com.example.kuit7_android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R


val KuitFontFamily = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold),
    Font(R.font.spoqa_han_sans_neo_thin, FontWeight.Thin),
    Font(R.font.spoqa_han_sans_neo_light, FontWeight.Light),
    Font(R.font.spoqa_han_sans_neo_medium, FontWeight.Medium)
)

data class KuitTypography(
    val B_24: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    val M_20: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    val B_16: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    val M_16: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    val R_16: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    val R_14: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    val B_13: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 13.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    val R_13: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 13.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Normal
    ),
    val R_12: TextStyle = TextStyle(
        fontFamily = KuitFontFamily,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Normal
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)