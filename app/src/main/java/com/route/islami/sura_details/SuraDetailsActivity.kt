package com.route.islami.sura_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName=intent.getStringExtra("fileName")
        val fileName=intent.getStringExtra("suraName")
        suraNameTitle = findViewById(R.id.suraNameTitle)
        sura= findViewById(R.id.sura)
        suraNameTitle.text = suraName
        readSuraFile(fileName?:"")
        sura.text = suraContent
    }
    fun readSuraFile(fileName: String){
        val reader = BufferedReader(
            InputStreamReader(assets.open(fileName))
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            reader.lines().toList().joinToString {
                suraContent += it
                return@joinToString ""
            }
        }

    }
}