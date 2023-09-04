package com.fetch.reward.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fetch.reward.R
import com.fetch.reward.datos.DataHiringItem
import com.fetch.reward.viewholder.VHListItemHiring

class AdapterListItemHiring(private val data:List<DataHiringItem>): RecyclerView.Adapter<VHListItemHiring>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHListItemHiring {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VHListItemHiring(layoutInflater.inflate(R.layout.item_hiring, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VHListItemHiring, position: Int) {
        val items = data[position]
        holder.bind(items)
    }
}