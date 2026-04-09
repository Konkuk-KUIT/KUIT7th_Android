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

                val navController = rememberNavController()
                /*이 프로그램에서 remembernavcontroller리모컨을 사용할건데 이걸 navcontroller라는 상수에 담아서
                함수들에게 전달하겠다*/
                Scaffold(//화면의 표준규격, 내가 만든 bottomnavbar를 bottombar자리에 배치해라
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavBar(navController)
                    }
                ) { innerPadding ->

                    MainNavHost(
                        padding = innerPadding,
                        navController = navController
                    )
                }
            }
        }
    }
}