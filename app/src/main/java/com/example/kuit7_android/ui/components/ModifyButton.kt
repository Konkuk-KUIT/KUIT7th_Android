package com.example.kuit7_android.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ModifyButton(
    onClick: () -> Unit,
    buttonName: String,
    bgColor: Color,
    textColor: Color,
    textstyle: TextStyle,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(width)
            .height(height),

        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(
            text = buttonName,
            style = textstyle,
            color = textColor
        )
    }
}