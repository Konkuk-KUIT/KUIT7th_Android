package com.example.kuit7_android.ui.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

// 변경한 부분: HomeDetailScreen 전체 구현 (4번 화면 - 기사 상세 페이지)
// ContactDetailScreen과 동일한 구조: navController.popBackStack()으로 뒤로가기 구현
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
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // 상단 앱바: 뒤로가기 버튼 + 로고 (ContactDetailScreen과 동일한 구조)
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
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

        // 기사 대표 이미지
        Image(
            painter = painterResource(article.image),
            contentDescription = "article image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            // 카테고리 배지
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF1877F2)
            ) {
                Text(
                    text = article.category,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 기사 제목
            Text(
                text = article.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                lineHeight = 26.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 신문사 + 시간 정보
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = "newspaper logo",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = article.newspaper,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4D4A63)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_clock),
                    contentDescription = "clock",
                    modifier = Modifier.size(14.dp),
                    tint = Color(0xFF4D4A63)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${article.time} ago",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF4D4A63)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 기사 본문 내용 (배경 박스 포함 - 4번 화면 디자인 참고)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF0F4FF),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = article.content,
                    fontSize = 15.sp,
                    color = Color(0xFF333333),
                    lineHeight = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeDetailScreenPreview() {
    val dummyArticle = Article(
        image = R.drawable.img_article1,
        category = "Europe",
        title = "Ukraine's President Zelensky to BBC: Blood money being paid for Russian oil",
        content = "This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content. This is a content.",
        time = "14m",
        newspaper = "BBC News"
    )
    HomeDetailScreen(
        article = dummyArticle,
        navController = rememberNavController()
    )
}