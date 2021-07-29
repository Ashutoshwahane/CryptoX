package xyz.cybernerd404.cryptox.view.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.cybernerd404.cryptox.model.CoinResponse
import xyz.cybernerd404.cryptox.model.NewsResponse
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.repository.CoinRepository
import xyz.cybernerd404.cryptox.repository.NewsRepository

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {
    private val _newsResponse: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val newsResponse: LiveData<Resource<NewsResponse>> /** to get the response value*/
        get() = _newsResponse

    fun getNews() {
        viewModelScope.launch {
            _newsResponse.value = repository.newApi()
        }
    }
}