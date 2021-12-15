package xyz.cybernerd404.cryptox.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.cybernerd404.cryptox.databinding.BlockItemLayoutBinding
import xyz.cybernerd404.cryptox.model.BlockModel


class BlockAdapter() :
    RecyclerView.Adapter<BlockAdapter.ViewHolder>() {
    var list: List<BlockModel> = arrayListOf()

    fun setBlock(response: List<BlockModel>) {
        this.list = response
        notifyItemChanged(list.size - 1)
        Log.d("debug", "date list: ${list.last()}")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BlockItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.blockTv.text = "#Block ${list.size}"
        holder.binding.hashValueItemTv.text = list[position].hash
        holder.binding.messageValueItemTv.text = list[position].message
        holder.binding.timeStampValueItemTv.text = list[position].time_stamp
        holder.binding.previousHashValueItemTv.text = list[position].previous_hash
        Log.d("debug", " on bind date list: ${list.last()}")

    }


    class ViewHolder(val binding: BlockItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}