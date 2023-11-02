package com.example.lab3

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    private lateinit var myImageView: ImageView
    private var clickCount = 0
    private lateinit var textCount: TextView
    private lateinit var linearLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myImageView = findViewById(R.id.imageView)
        linearLayout = findViewById(R.id.LinearLayout)
        textCount = findViewById(R.id.textView)

        myImageView.setOnClickListener(View.OnClickListener {
            clickCount++
            textCount.text = clickCount.toString()
            clickCheck()
        })
    }
    private fun clickCheck(){
        when (clickCount) {
            3 -> textCount.setTypeface(null,Typeface.BOLD_ITALIC)
            5 -> linearLayout.setBackgroundColor(resources.getColor(R.color.lime))
            7 -> textCount.textSize = 48f
        }
    }
}