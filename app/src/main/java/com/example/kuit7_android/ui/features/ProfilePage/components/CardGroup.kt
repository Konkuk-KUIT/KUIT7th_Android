package com.example.kuit7_android.ui.features.ProfilePage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.components.KuitCard
import com.example.kuit7_android.ui.theme.Gray400
import com.example.kuit7_android.ui.theme.KuitTheme



@Composable
fun CardGroup(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(34.dp)
    ) {
        repeat(2) { rowIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(34.dp)
            ) {
                repeat(2) { colIndex ->
                    val index = rowIndex * 2 + colIndex

                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        KuitCard(
                            modifier.aspectRatio(1f),
                            content = {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "글",
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(Modifier.height(10.dp))
                                    Text(
                                        text = "127",
                                        style = KuitTheme.typography.B_24,
                                    )
                                    Spacer(Modifier.height(4.dp))
                                    Text(
                                        text = "개 기사 읽음",
                                        style = KuitTheme.typography.R_12,
                                        color = Gray400
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}