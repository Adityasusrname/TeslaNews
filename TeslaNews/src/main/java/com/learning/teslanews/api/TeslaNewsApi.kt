package com.learning.teslanews.api

import com.learning.teslanews.models.TeslaNews
import retrofit2.Call
import retrofit2.http.GET
 interface TeslaNewsApi {

  @GET("everything?q=tesla&from=2021-09-04&sortBy=publishedAt&apiKey=")//Insert your API key you can also change the date from '2021-09-04' to a date of your choice
  suspend fun get_articles():TeslaNews
}