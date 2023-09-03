package com.fetch.reward.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fetch.reward.databinding.ItemHiringBinding

class VHListItemHiring(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemHiringBinding.bind(view)

    fun bind(item: String){
        binding.tvListID.text = "p"
        binding.tvId.text = "i"
        binding.tvName.text = "s"
    }
}