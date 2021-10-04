package com.learning.teslanews

import com.learning.teslanews.api.TeslaNewsApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



class TeslaNewsClient {
    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"

    }


    private val retrofit by lazy{
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()



    }
    val api by lazy {
        retrofit.create(TeslaNewsApi::class.java)

    }


}