package com.example.kuit7_android.ui.features.ProfilePage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.components.KuitCard
import com.example.kuit7_android.ui.components.KuitToggle
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun Settings(modifier: Modifier = Modifier) {
    KuitCard(
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(25.dp),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "푸시 알림",
                        style = KuitTheme.typography.M_16
                    )
                    KuitToggle(
                        checked = true
                    )
                }
                //Spacer(Modifier.height(14.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "다크 모드",
                        style = KuitTheme.typography.M_16
                    )
                    KuitToggle(
                        checked = false
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun ffff() {
    Settings()
}