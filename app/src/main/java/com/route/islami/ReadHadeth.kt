package com.route.islami

import android.os.Build
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.adapters.HadethNameAdapter
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.channels.AsynchronousSocketChannel.open
import java.nio.channels.FileChannel.open
import java.nio.channels.Pipe.open
import kotlin.streams.toList
//----------------------------------------------------Variables -------------------------------------
lateinit var adapter: HadethNameAdapter
val hadethNames : MutableList<String> = mutableListOf()
val ahadeth : MutableList<String> = mutableListOf()
lateinit var hadeth: String
lateinit var hadethCounter: Integer

//----------------------------------------------------------------------------------
class ReadHadeth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName=intent.getStringExtra("suraName")
        val fileName=intent.getStringExtra("fileName")
        //suraNameTitle = findViewById(R.id.suraNameTitle)
        // sura.movementMethod= ScrollingMovementMethod()
      //  backArrow = findViewById(R.id.backArrow)
//        backArrow.setOnClickListener{
//            finish()
//        }
       // sura= findViewById(R.id.sura)
        //suraNameTitle.text = suraName
        readSuraFile("ahadeth.txt")
       // sura.text = suraContent
    }

    public fun readSuraFile(fileName: String){
        val reader = application.assets.open(fileName)
        Log.e("#####",""+reader)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//            val lines =reader.
//            for (i in 0 ..lines.size-1){
//                val line = lines.get(i).split("#")
////                if(line.contains()){
////
////                    break
////                }
//               Log.e("#####",""+lines.get(i))
//
//
//            }
//        }

    }
}