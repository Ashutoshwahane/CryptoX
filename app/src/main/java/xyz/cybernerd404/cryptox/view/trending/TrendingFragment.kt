package xyz.cybernerd404.cryptox.view.trending

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_coin.*
import kotlinx.android.synthetic.main.fragment_trending.*
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.adapter.CardNewsAdapter
import xyz.cybernerd404.cryptox.adapter.TrendingNewsAdapter
import xyz.cybernerd404.cryptox.databinding.FragmentTrendingBinding
import xyz.cybernerd404.cryptox.network.CryptoApi
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.repository.NewsRepository
import xyz.cybernerd404.cryptox.utils.debug
import xyz.cybernerd404.cryptox.view.base.BaseFragment


class TrendingFragment : BaseFragment<NewsViewModel, FragmentTrendingBinding, NewsRepository>() {

    lateinit var newsAdapter: TrendingNewsAdapter
    lateinit var cardAdapter: CardNewsAdapter
    override fun getViewModel(): Class<NewsViewModel> = NewsViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentTrendingBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        NewsRepository(privateDataSource.buildApi(CryptoApi::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsAdapter = TrendingNewsAdapter(requireContext())
        cardAdapter = CardNewsAdapter(requireContext())

        binding.trendingNewsRv.adapter = newsAdapter
        binding.trendingNewsRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.cardNewsRv.adapter = cardAdapter
        binding.cardNewsRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.progessBarNews.visibility = View.VISIBLE

        viewModel.getNews()
        getData()

        swipe_trending.setOnRefreshListener {
            debug("swipe down to refresh the layout")
            getData()
        }


    }

    private fun getData() {
        viewModel.getNews()
        viewModel.newsResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    newsAdapter.setNews(it.value.data)
                    cardAdapter.setNews(it.value.data)
                    binding.progessBarNews.visibility = View.GONE
                    binding.swipeTrending.isRefreshing = false

                }
                is Resource.Failure -> {
                    binding.progessBarNews.visibility = View.GONE
                    Toast.makeText(requireContext(), "Response Failure", Toast.LENGTH_SHORT).show()
                    binding.swipeTrending.isRefreshing = false

                }
            }
        })
    }
}