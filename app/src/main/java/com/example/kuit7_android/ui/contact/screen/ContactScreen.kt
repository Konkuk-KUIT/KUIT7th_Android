package com.example.kuit7_android.ui.contact.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.R
import com.example.kuit7_android.navigation.Route
import com.example.kuit7_android.ui.contact.Call
import com.example.kuit7_android.ui.contact.component.CallItem

@Composable
fun ContactScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
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
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "연락처",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(39.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            items(callList) { call ->
                CallItem(
                    call = call,
                    onClick = {
                        navController.currentBackStackEntry
                            ?.savedStateHandle
                            ?.set("call", call)
                        navController.navigate(Route.CONTACT_DETAIL.route) {
                            launchSingleTop = true
                        }
                    }
                )
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
    ContactScreen(navController = rememberNavController())
}
