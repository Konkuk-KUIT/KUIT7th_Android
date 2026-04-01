package com.example.kuit7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    var currentTab by remember { mutableIntStateOf(0) }
    var selectedArticle by remember { mutableStateOf<NewsArticle?>(null) }
    var selectedCall by remember { mutableStateOf<Call?>(null) }

    val articles = listOf(
        NewsArticle(R.drawable.image1, "Europe", "Ukraine's President Zelensky to BBC: Blood money being paid...", "BBC News", R.drawable.bbc_icon, "14m ago"),
        NewsArticle(R.drawable.image2, "Travel", "Her train broke down. Her phone died. And then she met her..", "CNN", R.drawable.cnn_icon, "1h ago"),
        NewsArticle(R.drawable.image3, "Europe", "Russian warship: Moskva sinks in Black Sea", "BBC News", R.drawable.bbc_icon, "4h ago"),
        NewsArticle(R.drawable.image4, "Money", "Wind power produced more electricity than coal and nucle...", "USA Today", R.drawable.usat_icon, "4h ago"),
        NewsArticle(R.drawable.image5, "Life", "'We keep rising to new challenges:' For churches hit by...", "USA Today", R.drawable.usat_icon, "4h ago")
    )

    val callList = listOf(
        Call(R.drawable.phone1, "박서연", "010-1234-5678"),
        Call(R.drawable.phone2, "김건국", "010-1234-5678"),
        Call(R.drawable.phone3, "홍길동", "010-1234-5678")
    )

    when {
        selectedArticle != null -> {
            NewsDetailScreen(
                article = selectedArticle!!,
                onBack = { selectedArticle = null }
            )
        }
        selectedCall != null -> {
            ContactDetailScreen(
                call = selectedCall!!,
                onBack = { selectedCall = null }
            )
        }
        else -> {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        NavigationBarItem(
                            selected = currentTab == 0,
                            onClick = { currentTab = 0 },
                            icon = { Text("🏠", fontSize = 20.sp) },
                            label = { Text("홈") }
                        )
                        NavigationBarItem(
                            selected = currentTab == 1,
                            onClick = { currentTab = 1 },
                            icon = { Text("📞", fontSize = 20.sp) },
                            label = { Text("연락처") }
                        )
                    }
                }
            ) { padding ->
                when (currentTab) {
                    0 -> NewsScreen(
                        articles = articles,
                        onArticleClick = { selectedArticle = it },
                        modifier = Modifier.padding(padding)
                    )
                    1 -> ContactScreen(
                        callList = callList,
                        onContactClick = { selectedCall = it },
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}