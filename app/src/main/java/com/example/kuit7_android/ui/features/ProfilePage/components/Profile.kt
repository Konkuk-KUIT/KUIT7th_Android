package com.example.kuit7_android.ui.features.ProfilePage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.components.ButtonMain
import com.example.kuit7_android.ui.components.CutCircle
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CutCircle(R.drawable.img_profile1, 110.dp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "홍길동",
            style = KuitTheme.typography.B_24
        )
        Spacer(modifier = Modifier.height(18.dp))
        ButtonMain("프로필 수정")

    }
}