package xyz.cybernerd404.cryptox.repository

import xyz.cybernerd404.cryptox.network.CryptoApi

class CoinDetailRepository(
    private val api: CryptoApi
) : BaseRepository() {
    suspend fun getCoinApi(id: String) = safeApiCall {
        api.getCoinDetail(id)
    }
}