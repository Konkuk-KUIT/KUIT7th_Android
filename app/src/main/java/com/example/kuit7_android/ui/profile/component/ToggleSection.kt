package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.data.ToggleItemData
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ToggleSection(
    items: List<ToggleItemData>,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(2.dp, KuitTheme.colors.gray300),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier.padding(17.dp)
        ) {
            items.forEach { item ->
                ToggleRow(
                    label = item.label,
                    isChecked = item.isChecked,
                    onToggleChanged = item.onToggleChanged
                )
            }
        }
    }
}