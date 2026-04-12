package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_account),
                contentDescription = "profileImage",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "홍길동", style = KuitTheme.typography.B_24,
        )

        Spacer(modifier = Modifier.height(14.dp))

        ButtonComponent(
            label = "프로필 수정",
            color = KuitTheme.colors.main,
            font = KuitTheme.typography.M_16
        )
    }
}

@Preview
@Composable
fun ProfileSectionPreview(modifier: Modifier = Modifier) {
    ProfileSection()
}