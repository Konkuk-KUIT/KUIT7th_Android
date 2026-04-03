package com.example.kuit7_android.ui.contactDetail.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.components.Header
import com.example.kuit7_android.ui.contact.Call
import com.example.kuit7_android.ui.contact.data.CallItem.callList
import com.example.kuit7_android.ui.contact.screen.ContactScreen
import com.example.kuit7_android.ui.contactDetail.component.Button

@Composable
fun ContactDetailScreen(navController: NavController, contact: Call) {

    Column(
        Modifier.fillMaxSize()
    ) {
        Header(navController)
        Column(
            Modifier.padding(20.dp, 27.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(contact.image),
                    contentDescription = "profile",
                    modifier = Modifier.size(70.dp)
                )
                Spacer(Modifier.width(14.dp))
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = contact.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(500)
                    )
                    Text(
                        text = contact.phone,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(500)
                    )
                }
            }
            Spacer(Modifier.height(25.dp))
            Button("default", "정보수정")
            Spacer(Modifier.height(10.dp))
            Button("delete", "연락처 삭제")
        }
    }
}