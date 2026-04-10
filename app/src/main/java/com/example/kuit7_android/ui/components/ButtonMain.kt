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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.Black
import com.example.kuit7_android.ui.theme.KuitTheme
import com.example.kuit7_android.ui.theme.MainBlue
import com.example.kuit7_android.ui.theme.White

@Composable
fun ButtonMain(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    width: Dp = 150.dp,
    height: Dp = 45.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(width, height),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainBlue,
            contentColor = White
        ),
        border = BorderStroke(1.dp, Black),
        contentPadding = PaddingValues(0.dp) // 텍스트 중앙 정렬을 위해 패딩 제거
    ) {
        Text(
            text = text,
            style = KuitTheme.typography.M_16
        )
    }
}





