package xyz.cybernerd404.cryptox.view.home.wallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.adapter.HomeCoinAdapter
import xyz.cybernerd404.cryptox.adapter.HomeTokenAdapter
import xyz.cybernerd404.cryptox.databinding.FragmentCoinBinding
import xyz.cybernerd404.cryptox.databinding.FragmentHomeWalletBinding
import xyz.cybernerd404.cryptox.model.TokenModel

class HomeWalletFragment : Fragment() {

    lateinit var adapter : HomeTokenAdapter
    lateinit var binding: FragmentHomeWalletBinding
    lateinit var list: MutableList<TokenModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = arrayListOf()
        adapter = HomeTokenAdapter(requireContext())
        var tokenModel = TokenModel(1, "ETH", 1600)
        list.add(tokenModel)

        tokenModel = TokenModel(1, "ETH", 1600)
        list.add(tokenModel)

        tokenModel = TokenModel(1, "ETH", 1600)
        list.add(tokenModel)

        tokenModel = TokenModel(1, "ETH", 1600)
        list.add(tokenModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.assertsRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.assertsRv.adapter = adapter
        adapter.onRefresh(list)

    }
}