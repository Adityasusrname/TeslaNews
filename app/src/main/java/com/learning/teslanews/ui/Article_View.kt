package com.learning.teslanews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.learning.teslanews.R

class Article_View : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)
        val image=intent.getStringExtra("Image")
        val content=intent.getStringExtra("Content")

        val image_view=findViewById<ImageView>(R.id.image)
        val text_view=findViewById<TextView>(R.id.content)

        image_view.load(image)
        text_view.text=content

    }
}