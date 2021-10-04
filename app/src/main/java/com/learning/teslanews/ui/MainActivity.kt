package com.learning.teslanews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.teslanews.R
import com.learning.teslanews.Tesla_News_Repository.Tesla_News_Repo
import com.learning.teslanews.models.TeslaNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var view_model:MainAcitivity_ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_model= MainAcitivity_ViewModel()


/*runBlocking {
    launch(Dispatchers.IO){
        val response=Tesla_News_Repo().get_articles()
        val r_view=findViewById<RecyclerView>(R.id.r_view)
        val adapter=R_Adapter(response)
        r_view.adapter=adapter
        val layoutmanager=LinearLayoutManager(this@MainActivity)
        r_view.layoutManager=layoutmanager

    }
}*/   view_model.fetch_articles()
        view_model.articles.observe(this, Observer<List<TeslaNews.Article?>?>{

            val r_view=findViewById<RecyclerView>(R.id.r_view)
            val adapter=R_Adapter(it)
            r_view.adapter=adapter
            val layoutmanager=LinearLayoutManager(this)
            r_view.layoutManager=layoutmanager




        })
    }
}