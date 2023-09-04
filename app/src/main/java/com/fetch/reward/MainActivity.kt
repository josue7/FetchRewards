package com.fetch.reward

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.fetch.reward.databinding.ActivityMainBinding
import com.fetch.reward.datos.DataHiringItem
import com.fetch.reward.datos.ServiceData
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemHiringItem: List<DataHiringItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getElementsHiring()

    }
    private fun addData(): List<DataHiringItem>{
        val list = mutableListOf<DataHiringItem>()
        for (i in 10..18) {
            val item = DataHiringItem(i, (1..4).random(), "Item $i")
            list.add(item)
        }
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

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getElementsHiring(){

        val dataHirin = getRetrofit().create(ServiceData::class.java)
        dataHirin.getData().enqueue(object: Callback<List<DataHiringItem>>{
            override fun onResponse(
                call: Call<List<DataHiringItem>>,
                response: Response<List<DataHiringItem>>) {
                if (response.isSuccessful){
                    Log.i("DATAW", response.body().toString())
                    val data: List<DataHiringItem>? = response.body()!!
                    if (data != null) {
                        itemHiringItem = data
                        Log.i("ITEM", itemHiringItem.toString())
                        setTab()
                    }
                }
            }

            override fun onFailure(call: Call<List<DataHiringItem>>, t: Throwable) {
                showError()
            }
        })
    }

    private fun showError(){
        Toast.makeText(this, "Ha ocurrido algun error", Toast.LENGTH_SHORT).show()
    }
}