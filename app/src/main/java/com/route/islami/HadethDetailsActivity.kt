package com.route.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.route.islami.adapters.HadethNameAdapter
lateinit var backArrow: ImageView
lateinit var hadethNameTitle : TextView
lateinit var hadethContent: TextView

class HadethDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        hadethContent = findViewById(R.id.hadethContent)
        hadethNameTitle = findViewById(R.id.hadethNameTitle)
        hadethContent.text =  intent.getStringExtra("Hadeth")
        hadethNameTitle.text =  intent.getStringExtra("Title")
        backArrow = findViewById(R.id.backArrow)
        backArrow.setOnClickListener{
            finish()
        }
    }
}