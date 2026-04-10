package com.example.kuit7_android.ui.features.ProfilePage.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.ui.components.Header
import com.example.kuit7_android.ui.features.ProfilePage.components.CardGroup
import com.example.kuit7_android.ui.features.ProfilePage.components.NewsList
import com.example.kuit7_android.ui.features.ProfilePage.components.PlanUsage
import com.example.kuit7_android.ui.features.ProfilePage.components.Profile
import com.example.kuit7_android.ui.features.ProfilePage.components.Settings
import com.example.kuit7_android.ui.home.data.NewsItem.articles
import com.example.kuit7_android.ui.theme.Gray900
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navController : NavController) {
    Column() {
        Header(navController)
        LazyColumn(
            Modifier.padding(23.dp, 50.dp)
        ) {
            //프로필 영역
            item {
                Profile()
                Spacer(modifier = Modifier.height(18.dp))
            }
            //플랜
            item {
                PlanUsage()
                Spacer(modifier = Modifier.height(42.dp))
            }
            item {
            CardGroup()
            Spacer(modifier = Modifier.height(31.dp))
            }
            item {
                Settings()
                Spacer(modifier = Modifier.height(18.dp))
            }
            item {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                ) {
                    Text(
                        text = "저장한 기사",
                        style = KuitTheme.typography.M_20,
                        color = Gray900
                    )
                    Text(
                        text = "모두보기",
                        style = KuitTheme.typography.R_14,
                        color = Gray900
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
            }
            items(articles) {
                NewsList(navController=navController, article = it)
            }
        }
    }
}

@Preview
@Composable
private fun ppppp() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}