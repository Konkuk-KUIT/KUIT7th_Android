package com.example.kuit7_android.ui.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article

@Composable
fun HomeDetailScreen(
    article: Article,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val imageRes = when (article.newspaper) {
        "BBC News" -> R.drawable.ic_bbc
        "CNN" -> R.drawable.ic_cnn
        "USA Today" -> R.drawable.ic_usa
        else -> R.drawable.ic_bbc
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Image(
                painter = painterResource(article.image),
                contentDescription = "news_image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(19.dp))

            Box(
                modifier = Modifier
                    .size(width = 64.dp, height = 24.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFF1877F2))
            ) {
                Text(
                    article.category,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(Modifier.height(4.dp))
            Text(article.title, fontSize = 20.sp)
            Spacer(Modifier.height(13.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = "news_image",
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(4.dp))
                Text(article.newspaper)
                Spacer(Modifier.width(8.dp))

                Icon(
                    painter = painterResource(R.drawable.ic_clock),
                    contentDescription = "clock",
                    modifier = Modifier.size(14.dp)
                )
                Spacer(Modifier.width(3.dp))
                Text(article.time)
                Text(" ago")
            }

            Spacer(Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .border(
                        width = 1.2.dp,
                        color = Color(0xFF1877F2),
                        shape = RoundedCornerShape(15.dp)
                    )
            ) {
                Text(
                    article.content,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeDetailScreenPreview(modifier: Modifier = Modifier) {
    val dummyArticle = Article(
        image = R.drawable.img_article1,
        category = "Europe",
        title = "Ukraine's President Zelensky to BBC: Blood money being paid for Russian oil",
        content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
        time = "14m",
        newspaper = "BBC News"
    )

    HomeDetailScreen(dummyArticle, navController = rememberNavController())
}