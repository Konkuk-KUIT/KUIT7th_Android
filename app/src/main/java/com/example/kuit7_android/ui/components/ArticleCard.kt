package com.example.kuit7_android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article
import com.example.kuit7_android.ui.theme.KuitTheme

@Composable
fun ArticleCard(
    article: Article,
    modifier: Modifier = Modifier
) {
    val imageRes = when (article.newspaper) {
        "BBC News" -> R.drawable.ic_bbc
        "CNN" -> R.drawable.ic_cnn
        "USA Today" -> R.drawable.ic_usa
        else -> R.drawable.ic_bbc
    }

    Row(
        modifier = modifier
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
                style = KuitTheme.typography.R_12,
                color = KuitTheme.colors.gray400
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
                        style = KuitTheme.typography.B_13,
                        color = KuitTheme.colors.gray400,
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
}