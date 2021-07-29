package xyz.cybernerd404.cryptox.view.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.cybernerd404.cryptox.repository.BaseRepository
import xyz.cybernerd404.cryptox.repository.CoinRepository
import xyz.cybernerd404.cryptox.repository.NewsRepository
import xyz.cybernerd404.cryptox.view.coins.CoinViewModel
import xyz.cybernerd404.cryptox.view.trending.NewsViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(CoinViewModel::class.java) -> CoinViewModel(repository as CoinRepository) as T
            modelClass.isAssignableFrom(NewsViewModel::class.java) -> NewsViewModel(repository as NewsRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}