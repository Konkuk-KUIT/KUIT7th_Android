package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ArticleCard(
    article: Article,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
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
                style = KuitTheme.typography.R_16,
                color = KuitTheme.colors.gray900,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(4.dp))
            ArticleInfo(article)
        }
    }
}
    @Preview
    @Composable
    fun ArticleCardPreview(modifier: Modifier = Modifier) {
        val mockAtricle = Article(
            image = R.drawable.img_article2,
            category = "Travel",
            title = "Her train broke down. Her phone died. And then...",
            content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
            time = "1h ago",
            newspaper = "CNN"
        )

        ArticleCard(mockAtricle)
    }