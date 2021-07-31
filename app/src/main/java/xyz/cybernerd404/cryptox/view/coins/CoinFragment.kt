package xyz.cybernerd404.cryptox.view.coins

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.cybernerd404.cryptox.adapter.HomeCoinAdapter
import xyz.cybernerd404.cryptox.databinding.FragmentCoinBinding
import xyz.cybernerd404.cryptox.model.CoinResponseItem
import xyz.cybernerd404.cryptox.network.CryptoApi
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.repository.CoinRepository
import xyz.cybernerd404.cryptox.utils.CoinClickListener
import xyz.cybernerd404.cryptox.utils.debug
import xyz.cybernerd404.cryptox.utils.showToast
import xyz.cybernerd404.cryptox.view.base.BaseFragment
import xyz.cybernerd404.cryptox.view.coins.coinDetail.CoinDetailActivity


class CoinFragment : BaseFragment<CoinViewModel, FragmentCoinBinding, CoinRepository>(),
    CoinClickListener {

    lateinit var coinAdapter: HomeCoinAdapter

    override fun getViewModel() = CoinViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentCoinBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        CoinRepository(remoteDataSource.buildApi(CryptoApi::class.java))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coinAdapter = HomeCoinAdapter(requireContext(), this)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.homeCoinRv.adapter = coinAdapter
        binding.homeCoinRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.progessBarCoin.visibility = View.VISIBLE

        viewModel.getCoin()
        getData()
        /** Pull down to refresh the screen*/
        binding.swipe.setOnRefreshListener {
            debug("swipe down to refresh the layout")
            getData()

        }

    }

    private fun getData() {
        viewModel.getCoin()
        viewModel.coinResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    coinAdapter.setCoin(it.value)
                    binding.progessBarCoin.visibility = View.GONE
                    binding.swipe.isRefreshing = false

                }
                is Resource.Failure -> {
                    binding.progessBarCoin.visibility = View.GONE
                    binding.swipe.isRefreshing = false
                    Toast.makeText(requireContext(), "Response Failure", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun coinClickListener(coinResponseItem: CoinResponseItem) {
        activity.let {
            Intent(it, CoinDetailActivity::class.java).apply {
                putExtra("coin_id", coinResponseItem.id)
                putExtra("coin_name", coinResponseItem.name)

                startActivity(this)
            }
        }
    }


}