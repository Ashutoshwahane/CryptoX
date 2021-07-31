package xyz.cybernerd404.cryptox.network

import retrofit2.http.GET
import retrofit2.http.Path
import xyz.cybernerd404.cryptox.model.CoinResponse
import xyz.cybernerd404.cryptox.model.NewsResponse
import xyz.cybernerd404.cryptox.model.coindetail.CoinDetailResponse

const val getCoinsEndPoint = "coins/markets?vs_currency=inr&order=market_cap_desc&per_page=100&sparkline=true"
const val newEndPoint = "junk-data/main/crypto_news.json"
const val getCoinDetail = "coins/{id}/"

interface CryptoApi {

    @GET(getCoinsEndPoint)
    suspend fun getAllCoins(): CoinResponse

    @GET(newEndPoint)
    suspend fun getNews(): NewsResponse

    @GET(getCoinDetail)
    suspend fun getCoinDetail(
        @Path("id") id: String
    ): CoinDetailResponse

}