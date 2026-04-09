package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.ui.components.ModifyButton
import com.example.kuit7_android.ui.components.Profile

@Composable
fun ProfileCard(
    userName: String,
    profileImage: Int,
    pftextColor: Color,
    pftextstyle: TextStyle,
    onClick: () -> Unit,
    buttonName: String,
    bgColor: Color,
    mbtextColor: Color,
    mbtextstyle: TextStyle,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Profile(
            userName = userName,
            profileImage = profileImage,
            textColor = pftextColor,
            textstyle = pftextstyle
        )
        Spacer(modifier = Modifier.height(11.dp))
        ModifyButton(
            onClick = onClick,
            buttonName = buttonName,
            bgColor = bgColor,
            textColor = mbtextColor,
            textstyle = mbtextstyle,
            width = width,
            height = height
        )
    }
}