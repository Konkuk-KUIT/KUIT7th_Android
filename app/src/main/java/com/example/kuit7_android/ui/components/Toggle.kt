package com.example.kuit7_android.ui.components

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kuit7_android.ui.theme.Gray200
import com.example.kuit7_android.ui.theme.MainBlue
import com.example.kuit7_android.ui.theme.White

@Composable
fun KuitToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        colors = SwitchDefaults.colors(
            checkedThumbColor = White,
            checkedTrackColor = MainBlue,
            uncheckedThumbColor = White,
            uncheckedTrackColor = Gray200,
            // 테두리 색상 제거를 원할 경우 아래 설정 가능
            checkedBorderColor = MainBlue,
            uncheckedBorderColor = Gray200
        )
    )
}

@Preview
@Composable
private fun ppp() {
    KuitToggle(true)
}