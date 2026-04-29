package com.example.kuit7.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Main = Color(0xFFFF6F0F)
val Gray100 = Color(0xFFF5F5F5)
val Gray200 = Color(0xFFE0E0E0)
val Gray300 = Color(0xFF939DA9)
val Gray400 = Color(0xFF4E4B66)
val Gray900 = Color(0xFF1F1F1F)
val Red = Color(0xFFFA0C0C)

fun lightColors() = KuitColors(
    white = White,
    black = Black,
    main = Main,
    gray100 = Gray100,
    gray200 = Gray200,
    gray300 = Gray300,
    gray400 = Gray400,
    gray900 = Gray900,
    red = Red,
    isLightMode = true,
)

class KuitColors(
    white: Color,
    black: Color,
    main: Color,
    gray100: Color,
    gray200: Color,
    gray300: Color,
    gray400: Color,
    gray900: Color,
    red: Color,
    isLightMode: Boolean,
) {
    var white by mutableStateOf(value = white)
        private set
    var black by mutableStateOf(value = black)
        private set
    var main by mutableStateOf(value = main)
        private set
    var gray100 by mutableStateOf(value = gray100)
        private set
    var gray200 by mutableStateOf(value = gray200)
        private set
    var gray300 by mutableStateOf(value = gray300)
        private set
    var gray400 by mutableStateOf(value = gray400)
        private set
    var gray900 by mutableStateOf(value = gray900)
        private set
    var red by mutableStateOf(value = red)
        private set
    var isLightMode by mutableStateOf(value = isLightMode)
        private set

    fun copy(
        white: Color = this.white,
        black: Color = this.black,
        main: Color = this.main,
        gray100: Color = this.gray100,
        gray200: Color = this.gray200,
        gray300: Color = this.gray300,
        gray400: Color = this.gray400,
        gray900: Color = this.gray900,
        red: Color = this.red,
        isLightMode: Boolean = this.isLightMode,
    ) = KuitColors(
        white = white,
        black = black,
        main = main,
        gray100 = gray100,
        gray200 = gray200,
        gray300 = gray300,
        gray400 = gray400,
        gray900 = gray900,
        red = red,
        isLightMode = isLightMode,
    )

    fun update(other: KuitColors) {
        white = other.white
        black = other.black
        main = other.main
        gray100 = other.gray100
        gray200 = other.gray200
        gray300 = other.gray300
        gray400 = other.gray400
        gray900 = other.gray900
        red = other.red
        isLightMode = other.isLightMode
    }
}