package com.fetch.reward.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fetch.reward.databinding.ItemHiringBinding
import java.lang.invoke.MethodType

class VHListItemHiring(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemHiringBinding.bind(view)

    fun bind(item: MethodType){
        binding.tvListID.text = "p"
        binding.tvId.text = "i"
        binding.tvName.text = "s"
    }
}