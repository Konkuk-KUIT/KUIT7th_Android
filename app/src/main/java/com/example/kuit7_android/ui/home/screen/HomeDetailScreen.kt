package com.example.kuit7_android.ui.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
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
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = "back",
                )
            }
            Icon(
                painter = painterResource(R.drawable.kalar_logo),
                contentDescription = "logo",
                modifier = Modifier.align(Alignment.Center),
                tint = Color.Unspecified
            )
        }
        Spacer(Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(article.image),
                contentDescription = "article1",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.FillWidth//사진비율조정
            )
            Spacer(Modifier.height(19.dp))
            Text(
                text = article.category,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .background(
                        color = Color.Blue,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 1.dp)

            )
            Spacer(Modifier.height(3.dp))
            Text(
                text = article.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(13.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(

                    painter = painterResource(imageRes),
                    contentDescription = "newspapericon",
                    tint = Color.Unspecified,

                    )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = article.newspaper,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_clock),
                    contentDescription = "clockicon",
                    tint = Color.Unspecified,

                    )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = article.time,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(Modifier.height(20.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Blue,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(20.dp),
                text = article.content,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeDetailScreenPreview() {
    val dummyarticle = Article(
        image = R.drawable.img_article1,
        category = "Europe",
        title = "Ukraine's President Zelensky to BBC: Blood money being paid for Russian oil",
        content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
        time = "14m",
        newspaper = "BBC News"
    )
    HomeDetailScreen(
        article = dummyarticle,
        navController = rememberNavController()
    )
}