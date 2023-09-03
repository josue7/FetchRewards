package com.fetch.reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: FragmentActivity, private val tabCount: Int) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position){
            in 0..3 -> {
                val bundle = Bundle()
                val fragment = FragmentListID()
                val list = mutableListOf<String>()

                list.add("uyiiuy")
                bundle.putString("text", "LisID${position+1}")
                fragment.arguments = bundle
                return fragment
                //FragmentListID()
            }
            else -> FragmentListID()
        }
    }
}