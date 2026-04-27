package com.example.kuit7_android.ui.explore.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuit7_android.R
import com.example.kuit7_android.ui.explore.Topic
import com.example.kuit7_android.ui.home.Article

@Composable
fun ExploreScreen() {
    val topics = listOf(
        Topic(R.drawable.img_article1, "Health", "Get energizing workout moves, healthy recipes..."),
        Topic(R.drawable.img_article2, "Technology", "the application of scientific knowledge to the practi..."),
        Topic(R.drawable.img_article3, "Art", "Art is a diverse range of human activity, and result...")
    )

    val popularArticle = Article(
        image = R.drawable.img_article4,
        category = "Europe",
        title = "Russian warship: Moskva sinks in Black Sea",
        content = "",
        time = "4h ago",
        newspaper = "BBC News"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Explore", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Topic", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "See all", fontSize = 14.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(topics) { topic ->
            TopicCard(topic)
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Popular Topic", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            
            // Big Article Card
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = popularArticle.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = popularArticle.category, color = Color.Gray, fontSize = 14.sp)
                Text(text = popularArticle.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.ic_bbc), contentDescription = null, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = popularArticle.newspaper, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_clock),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = Color.Gray
                    )
                    Text(text = popularArticle.time, color = Color.Gray, fontSize = 14.sp)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = topic.image),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = topic.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = topic.description, fontSize = 14.sp, color = Color.Gray, maxLines = 2)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { /* TODO */ },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (topic.title == "Health") Color.White else Color(0xFF1877F2),
                contentColor = if (topic.title == "Health") Color(0xFF1877F2) else Color.White
            ),
            modifier = Modifier.width(84.dp).height(34.dp),
            border = if (topic.title == "Health") BorderStroke(1.dp, Color(0xFF1877F2)) else null
        ) {
            Text(text = if (topic.title == "Health") "Save" else "Saved", fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen()
}
