package xyz.cybernerd404.cryptox.repository

import xyz.cybernerd404.cryptox.network.CryptoApi

class CoinRepository(
    private val api: CryptoApi
) : BaseRepository() {
    suspend fun coinApi() = safeApiCall {
        api.getAllCoins()
    }
}