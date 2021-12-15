package xyz.cybernerd404.cryptox.view.home.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.cybernerd404.cryptox.adapter.HomeTokenAdapter
import xyz.cybernerd404.cryptox.databinding.FragmentHomeCalculatorBinding
import xyz.cybernerd404.cryptox.model.TokenModel

class HomeCalculatorFragment : Fragment() {

    lateinit var adapter : HomeTokenAdapter
    lateinit var binding: FragmentHomeCalculatorBinding
    lateinit var list: MutableList<TokenModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = arrayListOf()
        adapter = HomeTokenAdapter(requireContext())
        val tokenModel = TokenModel(1, "ETH", 1600)
        list.add(tokenModel)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.assertsRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.assertsRv.adapter = adapter
        adapter.onRefresh(list)

    }
}