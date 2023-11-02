package com.example.lab3

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.LinearLayout
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {
    private lateinit var myImageView: ImageView
    private var clickCount = 0.0
    private var upgradeCount = 0.0
    private lateinit var textCount: TextView
    private lateinit var linearLayoutMain: LinearLayout
    private lateinit var linearLayoutUpgrade: LinearLayout
    private lateinit var textUpgrade: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myImageView = findViewById(R.id.imageView)
        linearLayoutMain = findViewById(R.id.LinearLayout)
        textCount = findViewById(R.id.textView)
        textUpgrade = findViewById(R.id.textUpgrade)
        linearLayoutUpgrade = findViewById(R.id.linearLayoutUp)

        myImageView.setOnClickListener(View.OnClickListener {
            clickCount++
            textCount.text = clickCount.toString()
            clickCheck()
        })
        linearLayoutUpgrade.setOnClickListener(View.OnClickListener {
            if(clickCount >= 15.0 ){
                upgradeCount +=0.5
                clickCount-=15.0
                textUpgrade.text = "$upgradeCount cookie/s"
                textCount.text = clickCount.toString()
            }
        })
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                clickCount+=upgradeCount
                runOnUiThread {
                    textCount.text = clickCount.toString()
                }
            }
        }, 1000, 1000)
    }
    private fun clickCheck(){
        when (clickCount) {
            3.0 -> textCount.setTypeface(null,Typeface.BOLD_ITALIC)
            5.0 -> linearLayoutMain.setBackgroundColor(resources.getColor(R.color.lime))
            7.0 -> textCount.textSize = 48f
        }
    }
}