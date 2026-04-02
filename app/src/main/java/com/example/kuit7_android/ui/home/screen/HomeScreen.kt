package com.example.kuit7_android.ui.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.R
import com.example.kuit7_android.navigation.Route
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.home.component.CategoryRow
import com.example.kuit7_android.ui.home.component.ToggleTextRow

@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               navController: NavController
) {
    val articles = listOf<Article>(
        Article(
            image = R.drawable.img_article1,
            category = "Europe",
            title = "Ukraine's President Zelensky to BBC: Blood money being paid for Russian oil",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "14m",
            newspaper = "BBC News"
        ),
        Article(
            image = R.drawable.img_article2,
            category = "Travel",
            title = "Her train broke down. Her phone died. And then she met her future husband",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "1h",
            newspaper = "CNN"
        ),
        Article(
            image = R.drawable.img_article3,
            category = "Europe",
            title = "Russian warship: Moskva sinks in Black Sea",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "4h",
            newspaper = "BBC News"
        ),
        Article(
            image = R.drawable.img_article4,
            category = "Money",
            title = "Wind power produced more electricity than coal and nuclear sources for first time every",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "4h",
            newspaper = "USA Today"
        ),
        Article(
            image = R.drawable.img_article5,
            category = "Life",
            title = "'We keep rising to new challenges:' For churches hit by",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "4h",
            newspaper = "USA Today"
        ),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.kalar_logo),
                contentDescription = "logo",
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ToggleTextRow()

        Spacer(modifier = Modifier.height(16.dp))
        CategoryRow()

        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn(

        ) {
            items(articles) { article ->
                val imageRes = when (article.newspaper) {
                    "BBC News" -> R.drawable.ic_bbc
                    "CNN" -> R.drawable.ic_cnn
                    "USA Today" -> R.drawable.ic_usa
                    else -> R.drawable.ic_bbc
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable{
                            navController.currentBackStackEntry
                                ?.savedStateHandle
                                ?.set("article", article)


                            navController.navigate(Route.HOME_DETAIL.route){
                                launchSingleTop = true

                            }

                        }
                ) {
                    Image(
                        painter = painterResource(article.image),
                        contentDescription = "article image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(96.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = article.category,
                            fontSize = 14.sp,
                            color = Color(0xFF4D4A63)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = article.title,
                            fontSize = 16.sp,
                            color = Color.Black,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(imageRes),
                                    contentDescription = "newspaper",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = article.newspaper,
                                    fontSize = 14.sp,
                                    color = Color(0xFF4D4A63),
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    painter = painterResource(R.drawable.ic_clock),
                                    contentDescription = "clock",
                                    modifier = Modifier.size(14.dp)
                                )
                                Text(
                                    text = article.time,
                                    fontSize = 14.sp,
                                    color = Color(0xFF4D4A63),
                                    fontWeight = FontWeight.Light
                                )
                            }

                            Icon(
                                painter = painterResource(R.drawable.ic_etc),
                                contentDescription = "etc",
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController=rememberNavController())
}