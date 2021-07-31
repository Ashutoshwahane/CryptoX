package xyz.cybernerd404.cryptox.view.coins.coinDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.cybernerd404.cryptox.model.coindetail.CoinDetailResponse
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.repository.CoinDetailRepository

class CoinDetailViewModel(
    private val repository: CoinDetailRepository
) : ViewModel() {
    private val _coinDetailResponse: MutableLiveData<Resource<CoinDetailResponse>> = MutableLiveData()
    val coinDetailResponse: LiveData<Resource<CoinDetailResponse>> /** to get the response value*/
        get() = _coinDetailResponse

    fun getCoin(id: String) {
        viewModelScope.launch {
            _coinDetailResponse.value = repository.getCoinApi(id)
        }
    }
}