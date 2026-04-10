package com.example.kuit7_android.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R

// 1. FontFamily 정의 (res/font 폴더에 파일이 있어야 함)
val SpoqaHanSansNeo = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold),
    Font(R.font.spoqa_han_sans_neo_medium, FontWeight.Medium),
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal)
)

// 2. 프로젝트 전용 타이포그래피 데이터 클래스
@Immutable
data class KuitTypography(
    val B_24: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp
    ),
    val M_20: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 20.sp
    ),
    val B_16: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),
    val M_16: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),
    val R_16: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    val R_14: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp
    ),
    val B_13: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    val R_13: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    val R_12: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp
    )
)

val LocalKuitTypography = staticCompositionLocalOf { KuitTypography() }