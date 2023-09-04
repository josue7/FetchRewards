package com.fetch.reward.datos

import retrofit2.Call
import retrofit2.http.GET

interface ServiceData {
    @GET("hiring.json")
    fun getData(): Call<List<DataHiringItem>>
}