package xyz.cybernerd404.cryptox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_coin_item_view.view.*
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.databinding.CardNewsItemViewBinding
import xyz.cybernerd404.cryptox.databinding.TrendingNewsItemLayoutBinding
import xyz.cybernerd404.cryptox.model.Data


class CardNewsAdapter(private val context: Context) :
    RecyclerView.Adapter<CardNewsAdapter.ViewHolder>() {
    var list: List<Data> = arrayListOf()

    fun setNews(response: List<Data>) {
        this.list = response

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(CardNewsItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load(list[position].image_url)
            .placeholder(R.drawable.ic_coin)
            .into(holder.binding.cardIv)

        holder.binding.cardIv.clipToOutline = true
        holder.binding.titleCardNewsTv.text = list[position].title



    }


    class ViewHolder(val binding: CardNewsItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)


}