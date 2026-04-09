package com.example.kuit7_android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun Profile(
    userName: String,
    profileImage: Int,
    textColor: Color,
    textstyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(110.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(profileImage),
            contentDescription = "profileimg",
            modifier = Modifier.size(110.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = userName,
            style = textstyle,
            color = textColor
        )
    }
}
