package xyz.cybernerd404.cryptox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_coin_item_view.view.*
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.model.CoinResponseItem


class HomeCoinAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: List<CoinResponseItem> = arrayListOf()

    fun setCoin(response: List<CoinResponseItem>) {
        this.list = response
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_coin_item_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        Glide.with(context)
            .load(list[position].image)
            .placeholder(R.drawable.ic_coin)
            .centerCrop()
            .into(holder.itemView.coin_iv);

        holder.itemView.coin_rate_tv.text = list[position].current_price.toString() + "₹"
        holder.itemView.coin_title_tv.text = list[position].name
        holder.itemView.coin_symbol_tv.text = list[position].symbol

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var coinImage = view.coin_iv
        var coinTitle = view.coin_title_tv
        var coinRate = view.coin_rate_tv
    }

}