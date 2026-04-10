package com.example.kuit7_android.ui.features.homeDetail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R

@Composable
fun NewBottomGroup(
    modifier: Modifier = Modifier,
    newspaper: String,
    time: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val imageRes = when (newspaper) {
            "BBC News" -> R.drawable.ic_bbc
            "CNN" -> R.drawable.ic_cnn
            "USA Today" -> R.drawable.ic_usa
            else -> R.drawable.ic_bbc
        }
        Icon(
            painter = painterResource(imageRes),
            contentDescription = "newpaper logo",
            tint = Color.Unspecified,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier= Modifier.width(4.dp))
        Text(text = newspaper, fontSize = 13.sp, fontWeight = FontWeight(600), color = Color(0xFF4E4B66))

        Spacer(modifier= Modifier.width(8.dp))

        Icon(
            painter = painterResource(R.drawable.ic_clock),
            contentDescription = "clock",
            tint = Color.Unspecified,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier= Modifier.width(4.dp))
        Text(text = time, fontSize = 13.sp, color = Color(0xFF4E4B66))
    }
}

@Preview
@Composable
private fun nbgPrev() {
    NewBottomGroup(newspaper = "bbc", time = "100")
}