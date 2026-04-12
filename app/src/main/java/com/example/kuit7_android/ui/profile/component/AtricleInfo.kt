package com.example.kuit7_android.ui.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ArticleInfo(
    article: Article,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_cnn),
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
                style = KuitTheme.typography.R_13,
                color = KuitTheme.colors.gray400,
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

@Preview
@Composable
fun ArticleInfoPreview(modifier: Modifier = Modifier) {
    val mockArticle = Article(
        image = R.drawable.img_article2,
        category = "Travel",
        title = "Her train broke down. Her phone died. And then...",
        content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
        time = "1h ago",
        newspaper = "CNN"
    )

    ArticleInfo(mockArticle)
}