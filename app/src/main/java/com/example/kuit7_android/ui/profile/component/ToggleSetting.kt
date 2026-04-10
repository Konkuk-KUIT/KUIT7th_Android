package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.ui.theme.KuitTheme

private val SwitchBlue = Color(0xFF1877F2)
private val SwitchGray = Color(0xFFBDBDBD)

// 개별 토글 행 (라벨 + Switch)
@Composable
fun ToggleRow(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(37.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = KuitTheme.typography.M_16,
            color = KuitTheme.colors.gray900,
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = SwitchBlue,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = SwitchGray
            )
        )
    }
}

// 푸시알림 + 다크모드 토글을 하나의 테두리 카드로 묶음
@Composable
fun ToggleSetting(
    pushNotification: Boolean,
    darkMode: Boolean,
    onPushNotificationChange: (Boolean) -> Unit,
    onDarkModeChange: (Boolean) -> Unit
) {
    androidx.compose.foundation.layout.Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(114.dp)
            .border(
                width = 2.dp,
                color = KuitTheme.colors.gray300,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(20.dp)
    ) {
        ToggleRow(
            label = "푸시 알림",
            checked = pushNotification,
            onCheckedChange = onPushNotificationChange
        )
        ToggleRow(
            label = "다크 모드",
            checked = darkMode,
            onCheckedChange = onDarkModeChange
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ToggleSettingPreview() {
    ToggleSetting(
        pushNotification = true,
        darkMode = false,
        onPushNotificationChange = {},
        onDarkModeChange = {}
    )
}
