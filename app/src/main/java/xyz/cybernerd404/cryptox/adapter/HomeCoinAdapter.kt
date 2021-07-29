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
import xyz.cybernerd404.cryptox.model.CoinResponseItem


class HomeCoinAdapter(private val context: Context) :
    RecyclerView.Adapter<HomeCoinAdapter.ViewHolder>() {
    var list: List<CoinResponseItem> = arrayListOf()

    fun setCoin(response: List<CoinResponseItem>) {
        this.list = response
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(HomeCoinItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load(list[position].image)
            .placeholder(R.drawable.ic_coin)
            .into(holder.itemView.coin_iv)
        holder.binding.coinRateTv.text = "${list[position].current_price}₹"
        holder.binding.coinTitleTv.text = list[position].name
        holder.binding.coinSymbolTv.text = list[position].symbol


    }


    class ViewHolder(val binding: HomeCoinItemViewBinding) : RecyclerView.ViewHolder(binding.root)


}