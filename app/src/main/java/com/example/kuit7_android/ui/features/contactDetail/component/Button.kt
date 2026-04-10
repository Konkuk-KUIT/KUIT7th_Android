package com.example.kuit7_android.ui.features.contactDetail.component

import android.R.attr.text
import android.R.attr.textColor
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(type : String, text : String) {
    var modifier : Modifier = Modifier.clip(RoundedCornerShape(15.dp))
    var backgroundColor : Color
    var textColor : Color
    when(type){
        "default" -> {
            backgroundColor = Color(0xFF1877F2)
            textColor = Color.White
        }
        "delete" -> {
            backgroundColor = Color.White
            textColor = Color(0xFFFA0C0C)
            modifier = modifier.border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(15.dp))
        }
        else -> {
            backgroundColor = Color(0xFF1877F2)
            textColor = Color.White
        }
    }
    Box(
        modifier = modifier.background(
            color = backgroundColor
        )
            .fillMaxWidth()
            .padding(0.dp, 12.dp)
        ,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight(500),
            fontSize = 16.sp
        )

    }
}