package com.fetch.reward

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.fetch.reward.databinding.ActivityMainBinding
import com.fetch.reward.datos.DataHiringItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemHiringItem: List<DataHiringItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        itemHiringItem = addData()
        setTab()
    }
    private fun addData(): List<DataHiringItem>{
        val list = mutableListOf<DataHiringItem>()
        for (i in 10..18) {
            val item = DataHiringItem(i, (1..4).random(), "Item $i")
            list.add(item)
        }
        //list.shuffle()
        Log.i("DATOS", list.toString())
        return list
    }

    private fun setTab(){
        val adapter = ViewPagerAdapter(this, binding.tabMenu.tabCount, itemHiringItem)
        binding.vp2ListItem.adapter = adapter
        binding.vp2ListItem.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.tabMenu.selectTab(binding.tabMenu.getTabAt(position))
            }
        })

        binding.tabMenu.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.vp2ListItem.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }

            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })
    }
}