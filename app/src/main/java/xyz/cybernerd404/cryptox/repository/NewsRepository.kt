package xyz.cybernerd404.cryptox.repository

import xyz.cybernerd404.cryptox.network.CryptoApi

class NewsRepository(
    private val api: CryptoApi
) : BaseRepository() {
    suspend fun newApi() = safeApiCall {
        api.getNews()
    }
}