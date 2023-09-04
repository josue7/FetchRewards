package com.fetch.reward.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fetch.reward.databinding.ItemHiringBinding
import com.fetch.reward.datos.DataHiringItem

class VHListItemHiring(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemHiringBinding.bind(view)

    fun bind(item: DataHiringItem){
        binding.tvListID.text = item.listId.toString()
        binding.tvId.text = item.id.toString()
        binding.tvName.text = item.name
    }
}