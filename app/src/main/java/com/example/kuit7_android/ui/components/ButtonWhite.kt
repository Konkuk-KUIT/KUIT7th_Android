package com.example.kuit7_android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.Black
import com.example.kuit7_android.ui.theme.Gray900
import com.example.kuit7_android.ui.theme.KuitTheme
import com.example.kuit7_android.ui.theme.White

@Composable
fun ButtonWhite(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    width: Dp = 280.dp,
    height: Dp = 35.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(width, height),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = Gray900
        ),
        border = BorderStroke(1.dp, Black),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            style = KuitTheme.typography.R_13
        )
    }
}