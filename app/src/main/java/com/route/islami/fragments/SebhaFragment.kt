package com.route.islami.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.route.islami.AppState
import com.route.islami.R

class SebhaFragment : Fragment() {

    val tasbeh = listOf("سبحان الله", "الحمد لله", "الله اكبر")
    var tasbehIndx =AppState.tasbehIndex
    var sebhaIndex =AppState.sebhaCounter

override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sebhaImg = view.findViewById<ImageView>(R.id.sebha)
        var buttonClick = view.findViewById<Button>(R.id.sebhaCountbtn)
        var sebhaCount = view.findViewById<Button>(R.id.sebhaCount)
        sebhaCount.text = ""+AppState.sebhaCounter
        buttonClick.setText(""+tasbeh[tasbehIndx])
        buttonClick.setOnClickListener(){
            if(sebhaIndex ==33){
                sebhaIndex=-1
                AppState.sebhaCounter=-1
                sebhaImg.animate().rotation(360f).start();
                if(tasbehIndx <tasbeh.size-1){
                    tasbehIndx++
                    AppState.tasbehIndex++
                Log.e("SEBHA##","Tasbeh Index APPSTATE: "+AppState.tasbehIndex)
                Log.e("SEBHA##","Tasbeh Index: "+ tasbehIndx)
                }
                else{
                    Log.e("ELSE IF TASBEH ##", ""+tasbehIndx)
                    tasbehIndx=0
                    AppState.tasbehIndex=0
                    sebhaIndex=0
                    AppState.sebhaCounter=0
                }
                buttonClick.setText(""+tasbeh[AppState.tasbehIndex])
            }
            sebhaIndex++
            AppState.sebhaCounter++
            sebhaCount.setText(""+sebhaIndex)


        }
    }
}
