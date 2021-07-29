package xyz.cybernerd404.cryptox.model

data class Data(
    val date: String,
    val image_url: String,
    val news_url: String,
    val sentiment: String,
    val source_name: String,
    val text: String,
    val tickers: List<String>,
    val title: String,
    val topics: List<String>,
    val type: String
)