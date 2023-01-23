package com.route.islami.sura_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.route.islami.R
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

class SuraDetailsActivity : AppCompatActivity() {
    val lines :MutableList<String> = mutableListOf()
    var suraContent =""
    lateinit var suraNameTitle : TextView
    lateinit var sura : TextView
    lateinit var backArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName=intent.getStringExtra("suraName")
        val fileName=intent.getStringExtra("fileName")
        suraNameTitle = findViewById(R.id.suraNameTitle)
       // sura.movementMethod= ScrollingMovementMethod()
        backArrow = findViewById(R.id.backArrow)
        backArrow.setOnClickListener{
            finish()
        }
        sura= findViewById(R.id.sura)
        suraNameTitle.text = suraName
        readSuraFile("quran/"+fileName?:"")
        sura.text = suraContent
    }
    fun readSuraFile(fileName: String){
        val reader = BufferedReader(
            InputStreamReader(assets.open(fileName))
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            val lines =reader.lines().toList()
            for (i in 0 ..lines.size-1){
                val line = lines.get(i)
                suraContent += line +" (${i+1}) "
            }
        }

    }
}