package xyz.cybernerd404.cryptox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.databinding.HomeCoinItemViewBinding
import xyz.cybernerd404.cryptox.model.CoinResponseItem
import xyz.cybernerd404.cryptox.utils.CoinClickListener


class HomeCoinAdapter(private val context: Context, val coinClickListener: CoinClickListener) :
    RecyclerView.Adapter<HomeCoinAdapter.ViewHolder>() {
    var list: MutableList<CoinResponseItem> = arrayListOf()
    fun setCoin(response: MutableList<CoinResponseItem>) {
        this.list = response
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(HomeCoinItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load(list[position].image)
            .placeholder(R.drawable.ic_coin)
            .into(holder.binding.coinIv)

        holder.binding.coinIv.clipToOutline = true
        holder.binding.coinRateTv.text = "${list[position].current_price}₹"
        holder.binding.coinTitleTv.text = list[position].name
        holder.binding.coinSymbolTv.text = list[position].symbol

        holder.binding.root.setOnClickListener {
            coinClickListener.coinClickListener(list[position])
        }
    }


    class ViewHolder(val binding: HomeCoinItemViewBinding) : RecyclerView.ViewHolder(binding.root)


}