package xyz.cybernerd404.cryptox.view.coins

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.cybernerd404.cryptox.adapter.HomeCoinAdapter
import xyz.cybernerd404.cryptox.databinding.FragmentCoinBinding
import xyz.cybernerd404.cryptox.network.CryptoApi
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.repository.CoinRepository
import xyz.cybernerd404.cryptox.view.base.BaseFragment

class CoinFragment : BaseFragment<CoinViewModel, FragmentCoinBinding, CoinRepository>() {

    lateinit var coinAdapter :HomeCoinAdapter

    override fun getViewModel() = CoinViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCoinBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = CoinRepository(remoteDataSource.buildApi(CryptoApi::class.java))




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coinAdapter = HomeCoinAdapter(requireContext())
        binding.homeCoinRv.adapter = coinAdapter
        binding.homeCoinRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)

        viewModel.getCoin()
        binding.progessBarCoin.visibility = View.VISIBLE

        viewModel.coinResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {
                    coinAdapter.setCoin(it.value)
                    binding.progessBarCoin.visibility = View.GONE
                }
                is Resource.Failure -> {
                    binding.progessBarCoin.visibility = View.GONE
                    Toast.makeText(requireContext(), "Response Failure", Toast.LENGTH_SHORT).show()
                }
            }
        })




    }




}