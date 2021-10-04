package com.learning.teslanews.Tesla_News_Repository

import com.learning.teslanews.TeslaNewsClient
import com.learning.teslanews.models.TeslaNews

class Tesla_News_Repo {
    val api by lazy{
        TeslaNewsClient().api
    }
    suspend fun get_articles(): List<TeslaNews.Article?>? {
        val response=api.get_articles()
        return response.articles
    }
}