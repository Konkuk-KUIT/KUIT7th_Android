package com.example.kuit7_android.ui.Profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R

@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Magenta) // Profile Section 전체 박스
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Logo 영역 (Blue 박스)
        Box(modifier = Modifier.border(1.dp, Color.Blue).padding(4.dp)) {
            Text("Kabar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Profile Image 영역
        Box(modifier = Modifier.border(2.dp, Color(0xFF2196F3))) { // 파란색 박스
            Image(
                painter = painterResource(id = R.drawable.img_profile1),
                contentDescription = "Profile Image"
            )
        }
    }
}
