package xyz.cybernerd404.cryptox.network

import retrofit2.http.GET
import xyz.cybernerd404.cryptox.model.CoinResponse

const val getCoinsEndPoint = "coins/markets?vs_currency=inr&order=market_cap_desc&per_page=100&sparkline=true"


interface CryptoApi {

    @GET(getCoinsEndPoint)
    suspend fun getAllCoins(): CoinResponse
}