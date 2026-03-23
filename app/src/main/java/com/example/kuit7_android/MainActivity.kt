package com.example.kuit7_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.navigation.BottomNavBar
import com.example.kuit7_android.navigation.MainNavHost
import com.example.kuit7_android.ui.theme.KUIT7_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KUIT7_AndroidTheme {

                val navController = rememberNavController()   // ⭐ 핵심

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavBar(navController)           // ⭐ 하단바 연결
                    }
                ) { innerPadding ->

                    MainNavHost(                             // ⭐ 네비게이션 연결
                        padding = innerPadding,
                        navController = navController
                    )
                }
            }
        }
    }
}