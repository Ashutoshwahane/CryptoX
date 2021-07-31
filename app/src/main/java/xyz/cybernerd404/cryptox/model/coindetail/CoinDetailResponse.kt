package xyz.cybernerd404.cryptox.model.coindetail

data class CoinDetailResponse(
    var additional_notices: List<Any>? = arrayListOf(),
    var asset_platform_id: Any,
    var block_time_in_minutes: Int? = 0,
    var categories: List<String>? = arrayListOf(),
    var coingecko_rank: Int? = 0,
    var coingecko_score: Double? = 0.0,
    var community_data: CommunityData,
    var community_score: Double? = 0.0,
    var country_origin: String? = "",
    var description: Description,
    /*var developer_data: DeveloperData,*/
    var developer_score: Double? = 0.0,
    var genesis_date: String? = "",
    var hashing_algorithm: String? = "",
    var id: String? = "",
    var image: Image,
    var last_updated: String? = "",
    var links: Links,
    var liquidity_score: Double? = 0.0,
    /*var localization: Localization,*/
    var market_cap_rank: Int? = 0,
    var market_data: MarketData,
    var name: String? = "",
    /*var platforms: Platforms,*/
    var public_interest_score: Double? = 0.0,
    /*var public_interest_stats: PublicInterestStats,*/
    var public_notice: Any,
    var sentiment_votes_down_percentage: Double? = 0.0,
    var sentiment_votes_up_percentage: Double? = 0.0,
    var status_updates: List<Any>,
    var symbol: String? = "",
    /*var tickers: List<Ticker>*/
)