package com.learning.teslanews.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.learning.teslanews.R
import com.learning.teslanews.models.TeslaNews


class R_Adapter(private val articles:List<TeslaNews.Article?>?):RecyclerView.Adapter<R_Adapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView:ImageView
        val textView:TextView
        val cardview:CardView
        init {
            imageView=view.findViewById(R.id.image)
            textView=view.findViewById(R.id.description)
            cardview=view.findViewById(R.id.card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.article_container,parent,false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(articles?.get(position)?.description!=null && articles?.get(position)?.urlToImage!=null) {
            holder.textView.text = articles?.get(position)?.description.toString()
            holder.imageView.load(articles?.get(position)?.urlToImage)
            holder.cardview.setOnClickListener {
                val i= Intent(it.context,Article_View::class.java).apply {
                    putExtra("Image",articles[position]?.urlToImage.toString())
                    putExtra("Content",articles[position]?.content.toString())
                }
                it.context.startActivity(i)
            }
        }
    }

    override fun getItemCount()=articles!!.size
}