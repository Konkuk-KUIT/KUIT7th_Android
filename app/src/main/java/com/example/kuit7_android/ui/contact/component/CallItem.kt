package com.example.kuit7_android.ui.contact.component

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.ui.contact.Call
import com.example.kuit7_android.ui.contact.screen.ContactScreen

@Composable
fun CallItem(
    call: Call,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable{onClick()},
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(call.image),
            contentDescription = "profile",
            modifier = Modifier.size(63.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = call.name)
            Text(text = call.phone)
        }
    }
}