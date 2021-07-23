package xyz.cybernerd404.cryptox.view.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.cybernerd404.cryptox.repository.BaseRepository
import xyz.cybernerd404.cryptox.repository.CoinRepository
import xyz.cybernerd404.cryptox.view.coins.CoinViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(CoinViewModel::class.java) -> CoinViewModel(repository as CoinRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}