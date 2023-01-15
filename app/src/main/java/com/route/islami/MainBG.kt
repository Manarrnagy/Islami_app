package com.route.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.R.*;
import android.widget.ImageView

class MainBG : AppCompatActivity() {
    val tasbeh = listOf("سبحان الله", "الحمد لله", "الله اكبر")
     var tasbehIndx =0
     var sebhaIndex =1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bg)
        var sebhaImg = findViewById<ImageView>(R.id.sebha)
        var buttonClick = findViewById<Button>(R.id.sebhaCountbtn)
        var sebhaCount = findViewById<Button>(R.id.sebhaCount)
        buttonClick.setOnClickListener(){
            if(sebhaIndex ==30){
                sebhaIndex=-1
                sebhaImg.animate().rotation(360f).start();
                if(tasbehIndx <tasbeh.size){
                tasbehIndx++}
                else{
                    tasbehIndx=0
                }
                buttonClick.setText(""+tasbeh[tasbehIndx])
            }
            sebhaIndex++
            sebhaCount.setText(""+sebhaIndex)


        }
    }




//        fun OnTap(args: view:View?): Unit {
//        Button clickedbtn = (Button) view
//    }
}