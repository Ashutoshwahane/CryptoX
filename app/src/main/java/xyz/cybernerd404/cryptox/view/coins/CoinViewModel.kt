package xyz.cybernerd404.cryptox.view.coins

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.cybernerd404.cryptox.model.CoinResponse
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.repository.CoinRepository

class CoinViewModel(
    private val repository: CoinRepository
) : ViewModel() {
    private val _coinResponse: MutableLiveData<Resource<CoinResponse>> = MutableLiveData()
    val coinResponse: LiveData<Resource<CoinResponse>> /** to get the response value*/
        get() = _coinResponse

    fun getCoin() {
        viewModelScope.launch {
            _coinResponse.value = repository.coinApi()
        }
    }
}