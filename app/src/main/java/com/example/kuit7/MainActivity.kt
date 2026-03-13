package com.example.kuit7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kuit7.ui.theme.KUIT7week1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KUIT7week1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        Row {
                            Column(
                                Modifier
                                    .padding(top = 30.dp, start = 70.dp),
                                verticalArrangement = Arrangement.spacedBy(20.dp)
                            ) {
                                Box(
                                    Modifier
                                        .size(60.dp)
                                        .background(Color.Black, shape = RoundedCornerShape(20.dp))
                                )
                                Box(
                                    Modifier
                                        .size(60.dp)
                                        .border(
                                            width = 2.dp,
                                            color = Color.Black,
                                            shape = RoundedCornerShape(20.dp)
                                        )
                                )
                                Box(
                                    Modifier
                                        .size(76.dp)
                                        .border(width = 1.dp, color = Color.Black)
                                        .padding(8.dp)
                                        .background(Color.Red)
                                )
                                Image(
                                    painter = painterResource(R.drawable.image),
                                    contentDescription = "강아지 이미지",
                                    modifier = Modifier.size(80.dp)
                                )
                            }
                            Column(
                                Modifier
                                    .padding(top = 30.dp, start = 60.dp),
                                verticalArrangement = Arrangement.spacedBy(20.dp)
                            ) {
                                Box(
                                    Modifier
                                        .size(60.dp)
                                        .background(Color.Black, shape = CircleShape)
                                )
                                Box(
                                    Modifier
                                        .size(60.dp)
                                        .border(
                                            width = 2.dp,
                                            color = Color.Black,
                                            shape = CircleShape
                                        )
                                )
                                Box(
                                    Modifier
                                        .size(76.dp)
                                        .border(width = 1.dp, color = Color.Black)
                                        .padding(8.dp)
                                        .background(Color.Blue, CircleShape)
                                )
                                Image(
                                    painter = painterResource(R.drawable.image),
                                    contentDescription = "강아지 이미지",
                                    modifier = Modifier.size(80.dp)
                                        .clip(CircleShape)
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
