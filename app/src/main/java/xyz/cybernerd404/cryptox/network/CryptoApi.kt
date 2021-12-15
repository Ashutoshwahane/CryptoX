package xyz.cybernerd404.cryptox.network

import retrofit2.http.GET
import retrofit2.http.Path
import xyz.cybernerd404.cryptox.model.CoinResponse
import xyz.cybernerd404.cryptox.model.NewsResponse
import xyz.cybernerd404.cryptox.model.coindetail.CoinDetailResponse

/** api End point*/
const val getCoinsEndPoint = "coins/markets?vs_currency=inr&order=market_cap_desc&per_page=100&sparkline=false"
const val newEndPoint = "junk-data/main/crypto_news.json"
const val getCoinDetail = "coins/{id}/"

interface CryptoApi {

    /**
     * Get All Cryptocurrency coins
     * */
    @GET(getCoinsEndPoint)
    suspend fun getAllCoins(): CoinResponse

    /**
     * Get latest News about Cryptocurrency
     * */
    @GET(newEndPoint)
    suspend fun getNews(): NewsResponse

    /**
     * Get Coin Details like Market Cap,
     * description, last 24 hours high rate and low rate and many more
     * */
    @GET(getCoinDetail)
    suspend fun getCoinDetail(
        @Path("id") id: String
    ): CoinDetailResponse

}