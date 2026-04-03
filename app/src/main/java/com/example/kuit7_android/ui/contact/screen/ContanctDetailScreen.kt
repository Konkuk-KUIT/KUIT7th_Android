package com.example.kuit7_android.ui.contact.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.contact.Call

@Composable
fun ContactDetailScreen(
    call: Call,
    navController: NavController,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = {navController.popBackStack()},
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = "back"
                )

            }
            Icon(
                painter = painterResource(R.drawable.kalar_logo),
                contentDescription = "logo",
                modifier = Modifier.align(Alignment.Center),
                tint = Color.Unspecified
            )
        }
        Spacer(Modifier.height(27.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(call.image),
                contentDescription = "profile",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Column {
                Text(
                    text = call.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Text(
                    text = call.phone,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }
        Spacer(Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF1877f2))
            )
            {
                Text(
                    text = "정보 수정",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDDDDDD),
                        shape = RoundedCornerShape(15.dp)
                    ),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    text = "연락처 삭제",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFFA0C0C)
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun ContactDetailScreenPreview() {
    val dummyCall = Call(
        image = R.drawable.img_profile1,
        name = "박서연",
        phone = "010-1234-5678"
    )
    ContactDetailScreen(
        call = dummyCall,
        navController = rememberNavController()
    )
}