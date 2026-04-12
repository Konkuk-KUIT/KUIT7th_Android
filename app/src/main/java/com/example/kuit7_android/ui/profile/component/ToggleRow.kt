package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ToggleRow(
    label: String,
    isChecked: Boolean,
    onToggleChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = KuitTheme.colors.gray900, style = KuitTheme.typography.M_16)

        Switch(
            checked = isChecked,
            onCheckedChange = { newValue ->
                onToggleChanged(newValue)
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = KuitTheme.colors.main
            )
        )
    }
}

@Preview
@Composable
fun toggleRowPreview(modifier: Modifier = Modifier) {
    ToggleRow("푸시 알림", false, {})
}