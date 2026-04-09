package com.example.kuit7_android.ui.theme

import android.R.color.black
import android.R.color.white
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val White=Color(0xFFFFFFFF)
val BLack=Color(0xFF000000)
val Main=Color(0xFF1877F2)
val Gray100=Color(0xFFF3F4F6)
val Gray200=Color(0xFFBDBDBD)
val Gray300=Color(0xFF939DA9)
val Gray400=Color(0xFF4E4B66)
val Gray900=Color(0xFF1F1F1F)
val Red=Color(0xFFFA0C0C)

fun lightColors()=KuitColors(
    white=White,
    black=Black,
    main=Main,
    gray100=Gray100,
    gray200=Gray200,
    gray300=Gray300,
    gray400=Gray400,
    gray900=Gray900,
    red=Red,
    isLightMode=true
)
class KuitColors(
    white:Color,
    black:Color,
    main:Color,
    gray100:Color,
    gray200:Color,
    gray300:Color,
    gray400:Color,
    gray900:Color,
    red:Color,
    isLightMode:Boolean
){
    var white by mutableStateOf(white)
        private set     //쓰는이유? 클래스 외부에서의 접근 방지
    var black by mutableStateOf(black)
        private set
    var main by mutableStateOf(main)
        private set
    var gray100 by mutableStateOf(gray100)
        private set
    var gray200 by mutableStateOf(gray200)
        private set
    var gray300 by mutableStateOf(gray300)
        private set
    var gray400 by mutableStateOf(gray400)
        private set
    var gray900 by mutableStateOf(gray900)
        private set
    var red by mutableStateOf(red)
        private set
    var isLightMode by mutableStateOf(isLightMode)

    /*fun temp(){
        copy(white=Color(0xff000000))       //현제객체에서 white값만 바뀐 객체 반환
    }*/
    fun copy(
        white:Color=this.white,
        black:Color=this.black,
        main:Color=this.main,
        gray100:Color=this.gray100,
        gray200:Color=this.gray200,
        gray300:Color=this.gray300,
        gray400:Color=this.gray400,
        gray900:Color=this.gray900,
        red:Color=this.red,
        isLightMode:Boolean=this.isLightMode
    )=KuitColors(
        white=white,
        black=black,
        main=main,
        gray100=gray100,
        gray200=gray200,
        gray300=gray300,
        gray400=gray400,
        gray900=gray900,
        red=red,
        isLightMode=isLightMode
    )

    fun update(other:KuitColors){
        this.white=other.white
        this.black=other.black
        this.main=other.main
        this.gray100=other.gray100
        this.gray200=other.gray200
        this.gray300=other.gray300
        this.gray400=other.gray400
        this.gray900=other.gray900
        this.red=other.red
        this.isLightMode=other.isLightMode
    }
}