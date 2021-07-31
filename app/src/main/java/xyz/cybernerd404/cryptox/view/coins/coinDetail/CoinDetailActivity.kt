package xyz.cybernerd404.cryptox.view.coins.coinDetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.databinding.ActivityCoinDetailBinding
import xyz.cybernerd404.cryptox.network.CryptoApi
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.repository.CoinDetailRepository
import xyz.cybernerd404.cryptox.utils.showToast
import xyz.cybernerd404.cryptox.view.base.BaseActivity

class CoinDetailActivity : BaseActivity<CoinDetailViewModel, ActivityCoinDetailBinding, CoinDetailRepository>(ActivityCoinDetailBinding::inflate) {

    override fun getViewModel(): Class<CoinDetailViewModel> = CoinDetailViewModel::class.java

    override fun getFragmentRepository() = CoinDetailRepository(remoteDataSource.buildApi(CryptoApi::class.java))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.progessBarCoinDetail.visibility = View.VISIBLE
        val intent = intent.extras
        val coinId = intent?.getString("coin_id")
        val coinName = intent?.getString("coin_name")
        binding.coinDetailTitleTv.text = coinName
        binding.backCoinDetailFab.setOnClickListener {
            finish()
        }
        binding.addToWatchlistFab.setImageResource(R.drawable.ic_icon_favorite_border)

        var isSelected = false
        binding.addToWatchlistFab.setOnClickListener {
            isSelected = if (isSelected){
                binding.addToWatchlistFab.setImageResource(R.drawable.ic_icon_favorite)
                false
            }else{
                binding.addToWatchlistFab.setImageResource(R.drawable.ic_icon_favorite_border)
                true
            }
        }

        viewModel.getCoin(coinId.toString())
        getData()


    }

    fun getData(){
        viewModel.coinDetailResponse.observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.coinDetailTitleTv.text = it.value.name
                    binding.coinDetailIv.clipToOutline = true
                    binding.coinDetailCurrentPriceTv.text = it.value.market_data.current_price.usd.toString()
                    binding.last24Tv.text = it.value.market_data.price_change_percentage_24h.toString()
                    binding.last2weekTv.text = it.value.market_data.price_change_percentage_14d.toString()
                    binding.last1yearTv.text = it.value.market_data.price_change_percentage_1y.toString()
                    binding.todaysLowTv.text = it.value.market_data.low_24h.usd.toString()
                    binding.todaysHighTv.text = it.value.market_data.high_24h.usd.toString()
                    binding.blockTimeTv.text = it.value.block_time_in_minutes.toString()
                    binding.hashTv.text = it.value.hashing_algorithm.toString()
                    binding.descTv.text = it.value.description.en.toString()
                    Glide.with(this)
                        .load(it.value.image.large)
                        .placeholder(R.drawable.ic_coin)
                        .into(binding.coinDetailIv)
                    binding.progessBarCoinDetail.visibility = View.GONE
                }
                is Resource.Failure -> {
                    showToast(this, "Response Failed")
                    binding.progessBarCoinDetail.visibility = View.GONE
                }
            }
        })
    }


}