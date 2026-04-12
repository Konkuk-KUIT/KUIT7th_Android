package com.example.kuit7_android.ui.profile.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ButtonComponent(
    label: String,
    color: Color,
    font: TextStyle,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
    ) {
        Text(
            label,
            color = if (color ==
                KuitTheme.colors.white
            ) KuitTheme.colors.gray900 else KuitTheme.colors.white,
            style = font
        )
    }
}

@Preview
@Composable
fun ButtonComponentPreview(modifier: Modifier = Modifier) {
    ButtonComponent(
        label = "프로필 수정",
        color = KuitTheme.colors.main,
        font = KuitTheme.typography.M_16
    )
}