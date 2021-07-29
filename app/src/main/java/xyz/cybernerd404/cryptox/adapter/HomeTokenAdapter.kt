package xyz.cybernerd404.cryptox.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.cybernerd404.cryptox.databinding.HomeTokenItemViewBinding
import xyz.cybernerd404.cryptox.model.TokenModel


class HomeTokenAdapter(private val context: Context) : RecyclerView.Adapter<HomeTokenAdapter.ViewHolder>() {

    private var listData: List<TokenModel> = arrayListOf()

    fun onRefresh(listData: List<TokenModel>) {
        this.listData = listData
        try {
            notifyDataSetChanged()
        }catch (e: Exception){
            Log.e("error", "exception: $e")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HomeTokenItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listData[position]
        holder.binding.tokenAmount.text = "${list.tokenAmount}"
        holder.binding.tokenName.text = list.tokenName
        holder.binding.tokenInUsd.text = list.amountInDollar.toString()

    }

    class ViewHolder(val binding: HomeTokenItemViewBinding) : RecyclerView.ViewHolder(binding.root)
}

