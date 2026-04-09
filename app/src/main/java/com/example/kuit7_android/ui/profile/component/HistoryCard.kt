package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun HistoryCard(
    icon: Int,
    mainText: String,
    subText: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(15.dp),
                color = KuitTheme.colors.gray300
            )
            .size(140.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(Modifier.height(7.dp))
        Text(
            text = mainText,
            style = KuitTheme.typography.B_24,
            color = KuitTheme.colors.gray900
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = subText,
            style = KuitTheme.typography.R_12,
            color = KuitTheme.colors.gray400
        )
    }
}