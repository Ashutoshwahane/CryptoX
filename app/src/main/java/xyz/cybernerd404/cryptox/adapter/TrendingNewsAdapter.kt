package xyz.cybernerd404.cryptox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_coin_item_view.view.*
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.databinding.HomeCoinItemViewBinding
import xyz.cybernerd404.cryptox.databinding.HomeTokenItemViewBinding
import xyz.cybernerd404.cryptox.databinding.TrendingNewsItemLayoutBinding
import xyz.cybernerd404.cryptox.model.CoinResponseItem
import xyz.cybernerd404.cryptox.model.Data


class TrendingNewsAdapter(private val context: Context) :
    RecyclerView.Adapter<TrendingNewsAdapter.ViewHolder>() {
    var list: List<Data> = arrayListOf()

    fun setNews(response: List<Data>) {
        this.list = response
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(TrendingNewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load(list[position].image_url)
            .placeholder(R.drawable.ic_coin)
            .override(1000, 60)
            .into(holder.binding.newsItemIv)

        holder.binding.newsTitleTv.text = list[position].title


    }


    class ViewHolder(val binding: TrendingNewsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)


}