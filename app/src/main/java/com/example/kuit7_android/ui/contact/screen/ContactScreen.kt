package com.example.kuit7_android.ui.contact.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.contact.Call

@Composable
fun ContactScreen(modifier: Modifier = Modifier) {
    val callList = listOf<Call>(
        Call(
            image = R.drawable.img_profile1,
            name = "박서연",
            phone = "010-1234-5678"
        ),
        Call(
            image = R.drawable.img_profile2,
            name = "김건국",
            phone = "010-1234-5678"
        ),
        Call(
            image = R.drawable.img_profile3,
            name = "홍길동",
            phone = "010-1234-5678"
        )
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "연락처",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(39.dp))
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)) {
            items(callList) { call ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(call.image),
                        contentDescription = "profile",
                        modifier = Modifier.size(63.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = call.name)
                        Text(text = call.phone)
                    }
                }
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactScreenPreview() {
    ContactScreen()
}