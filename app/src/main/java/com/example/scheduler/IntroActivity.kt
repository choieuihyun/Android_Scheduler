package com.example.scheduler

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro)

        var textList = mutableListOf<String>()
        textList.add("매 순간 최선을 다 해\n\n 살지 않았다면 \n\n 시간을 더 바랄 자격은 없는거야 \n\n -Ekko-")
        textList.add("I never lose.\n\n I either win or learn \n\n -Conor Mcgregor-")

        val tv = findViewById<TextView>(R.id.introText)
        val range = (0..textList.size-1)

        tv.setText(textList[range.random()])

        var handler = Handler()
        handler.postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 5000)

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}