package xyz.cybernerd404.cryptox.network

import retrofit2.http.GET
import xyz.cybernerd404.cryptox.model.CoinResponse

const val getCoinsEndPoint = "coins/markets?vs_currency=inr&order=market_cap_desc&per_page=10&page=1&sparkline=false/"


interface CryptoApi {

    @GET(getCoinsEndPoint)
    suspend fun getAllCoins(): CoinResponse
}