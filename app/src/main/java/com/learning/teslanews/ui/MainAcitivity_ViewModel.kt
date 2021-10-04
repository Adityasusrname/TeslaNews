package com.learning.teslanews.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.teslanews.Tesla_News_Repository.Tesla_News_Repo
import com.learning.teslanews.models.TeslaNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainAcitivity_ViewModel: ViewModel() {
    private val _articles=MutableLiveData<List<TeslaNews.Article?>?>()
    val articles:LiveData<List<TeslaNews.Article?>?> =_articles

fun fetch_articles()=viewModelScope.launch(Dispatchers.IO) {
    Log.i("Hello","Bye")
    val response=Tesla_News_Repo().get_articles()
    _articles.postValue(response)

}

    }




