package com.example.kuit7_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                // 1. NavController 생성: 화면 이동을 관리하는 핵심 객체입니다.
                val navController = rememberNavController()

                // 2. Scaffold: 앱의 기본 레이아웃 구조를 제공합니다. (상단바, 하단바, 플로팅 버튼 등)
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    // 하단 내비게이션 바 설정
                    bottomBar = {
                        BottomNavBar(navController)
                    }
                ) { innerPadding ->
                    // 3. MainNavHost: 실제 화면이 교체되는 영역입니다.
                    // Scaffold에서 제공하는 innerPadding을 전달하여 하단바 등에 화면이 가려지지 않게 합니다.
                    MainNavHost(
                        padding = innerPadding,
                        navController = navController
                    )
                }
            }
        }
    }
}
