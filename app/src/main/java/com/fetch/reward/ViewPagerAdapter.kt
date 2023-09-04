package com.fetch.reward

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fetch.reward.datos.DataHiringItem

class ViewPagerAdapter(fragment: FragmentActivity, private val tabCount: Int, private var itemHiring: List<DataHiringItem>) : FragmentStateAdapter(fragment) {
    private val orderHiring = ordeListHiring(itemHiring)

    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position){

            0 -> {
                val fragment = FragmentListID()
                val listFilter = filterByListId(orderHiring, 1)
                Log.i("DATA FILTER1", listFilter.toString())
                fragment.setListData(listFilter)
                return fragment
            }
            1 -> {
                val fragment = FragmentListID()
                val listFilter = filterByListId(orderHiring, 2)
                Log.i("DATA FILTER2", listFilter.toString())
                fragment.setListData(listFilter)
                return fragment
            }
            2 -> {
                val fragment = FragmentListID()
                val listFilter = filterByListId(orderHiring, 3)
                Log.i("DATA FILTER2", listFilter.toString())
                fragment.setListData(listFilter)
                return fragment
            }
            3-> {
                val fragment = FragmentListID()
                val listFilter = filterByListId(orderHiring, 4)
                Log.i("DATA FILTER4", listFilter.toString())
                fragment.setListData(listFilter)
                return fragment
            }
            else -> FragmentListID()
        }
    }

    private fun ordeListHiring(dataHiring: List<DataHiringItem>): List<DataHiringItem> =
        dataHiring.sortedWith(compareBy ( {it.listId}, {it.name} ))

    private fun filterByListId(dataHiring: List<DataHiringItem>, id: Int): List<DataHiringItem> =
        dataHiring.filter { it.listId == id }

}