package com.example.kuit7_android.ui.home.data

import com.example.kuit7_android.R
import com.example.kuit7_android.ui.home.Article

object NewsItem {
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
}