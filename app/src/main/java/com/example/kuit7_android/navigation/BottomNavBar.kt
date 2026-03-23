package com.example.kuit7_android.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(
    navController: NavHostController
) {
    val tabs = NavTab.entries

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
            }
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEach { tab ->

            val isSelected = currentRoute == tab.route.route

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable {
                        navController.navigate(tab.route.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
            ) {
                Icon(
                    painter = painterResource(tab.icon),
                    contentDescription = tab.label,
                    tint = if (isSelected) Color(0xFF4E76E7) else Color.Gray,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = tab.label,
                    fontSize = 12.sp,
                    color = if (isSelected) Color(0xFF4E76E7) else Color.Gray
                )
            }
        }
    }
}