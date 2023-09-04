package com.fetch.reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fetch.reward.datos.DataHiringItem

class ViewPagerAdapter(fragment: FragmentActivity, private val tabCount: Int, private var itemHiring: List<DataHiringItem>) : FragmentStateAdapter(fragment) {
    private val orderHiring = ordeListHiring(itemHiring)
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position){

            in 0..3 -> {
                val fragment = FragmentListID()
                //val list = mutableListOf<String>()
                fragment.setListData(orderHiring)

                //bundle.putString("text", "LisID${position+1}")
                //fragment.arguments = bundle
                return fragment
                //FragmentListID()
            }
            else -> FragmentListID()
        }
    }

    private fun ordeListHiring(dataHiring: List<DataHiringItem>): List<DataHiringItem> =
        dataHiring.sortedWith(compareBy ( {it.listId}, {it.name} ))

}