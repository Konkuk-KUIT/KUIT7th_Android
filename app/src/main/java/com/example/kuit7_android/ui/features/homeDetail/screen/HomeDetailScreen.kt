package com.example.kuit7_android.ui.features.homeDetail.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.features.homeDetail.component.ContentBox
import com.example.kuit7_android.ui.components.Header
import com.example.kuit7_android.ui.features.homeDetail.component.NewBottomGroup
import com.example.kuit7_android.ui.features.homeDetail.component.Tag

@Composable
fun HomeDetailScreen(navController: NavController, article: Article) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(navController)
        Column(
            modifier = Modifier.padding(30.dp, 0.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(article.image),
                contentDescription = "news thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(18.dp))
            Tag(tag = article.category)
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = article.title,
                fontSize = 16.sp,
                letterSpacing = 0.12.sp,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(13.dp))

            NewBottomGroup(newspaper = article.newspaper, time = article.time)

            Spacer(modifier = Modifier.height(20.dp))

            ContentBox(content = article.content)
        }
    }
}