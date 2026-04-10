package com.example.kuit7_android.ui.features.contact.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kuit7_android.ui.features.contact.component.CallItem
import com.example.kuit7_android.ui.features.contact.data.CallItem.callList

@Composable
fun ContactScreen(navController: NavController, modifier: Modifier = Modifier) {
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
                Box(
                    Modifier.clickable{
                        navController.navigate(call)
                    }
                ) {
                    CallItem(call = call)
                }
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

            }
        }
    }
}
