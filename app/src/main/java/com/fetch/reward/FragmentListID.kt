package com.fetch.reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.fetch.reward.adapter.AdapterListItemHiring
import com.fetch.reward.databinding.FragmentListidBinding
import com.fetch.reward.datos.DataHiringItem

class FragmentListID : Fragment() {
    private lateinit var binding: FragmentListidBinding
    private lateinit var listHiringAdapter: AdapterListItemHiring
    private lateinit var itemHiring: List<DataHiringItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(itemHiring, view)
    }

    private fun initRecyclerView(item: List<DataHiringItem>, view: View){
        itemHiring = item

        listHiringAdapter = AdapterListItemHiring(itemHiring)

        binding.rvListItem.setHasFixedSize(true)
        binding.rvListItem.layoutManager = GridLayoutManager(view.context, 2)
        binding.rvListItem.adapter = listHiringAdapter
    }

    fun setListData(list: List<DataHiringItem>) {
        itemHiring = list
    }
}