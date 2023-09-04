package com.fetch.reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        //val bundle = arguments
        //val value = bundle?.getString("text").toString()

        binding = FragmentListidBinding.inflate(inflater, container, false)


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_listid, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(itemHiring, view)

        /*binding.btnFilterNullblanck.setOnClickListener {
            initRecyclerView(filteredList(itemHiring), view)
        }*/

        //binding.txFrag.text = arguments?.getString("text").toString()
        //Toast.makeText(view.context, , Toast.LENGTH_LONG).show()
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

    //fun filteredList(list: List<DataHiringItem>) = list.filterNotNull().filter { it.name.isNullOrEmpty() }
}