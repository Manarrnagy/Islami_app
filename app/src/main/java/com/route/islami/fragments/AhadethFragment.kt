package com.route.islami.fragments

import android.content.Intent
import android.hardware.Camera.open
import android.os.Build
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.system.Os.open
import android.system.Os.read
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R
import com.route.islami.adapters.HadethNameAdapter
import com.route.islami.adapters.SuraNameAdapter
import com.route.islami.sura_details.SuraDetailsActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.AsynchronousServerSocketChannel.open
import java.nio.channels.AsynchronousSocketChannel.open
import java.nio.channels.DatagramChannel.open
import java.nio.channels.FileChannel.open
import java.nio.channels.Pipe.open
import java.nio.channels.ServerSocketChannel.open
import kotlin.streams.toList
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.Hadeth
import com.route.islami.ReadHadeth


class AhadethFragment : Fragment() {

    lateinit var adapter: HadethNameAdapter
     var hadethNames : MutableList<String> = mutableListOf()
    val ahadeth : MutableList<String> = mutableListOf()
    lateinit var hadeth: String
    lateinit var hadethCounter: Integer
    var number =1;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.hadethRv)
        adapter = HadethNameAdapter(hadethNames)
        readSuraFile("ahadeth.txt")
        adapter.onItemClick = object : HadethNameAdapter.OnItemClick{
//            override fun onSuraNameClick(sura: String, postion: Int) {
//                val fileName = "${postion+1}.txt"
//                val intent = Intent(requireActivity(), SuraDetailsActivity::class.java)
//                intent.putExtra("fileName","${postion+1}.txt")
//                intent.putExtra("suraName",sura)
//                startActivity(intent)
//            }

            override fun onHadethNameClick(hadeth: String, postion: Int) {
                TODO("Not yet implemented")
            }

        }
        recyclerView.adapter = adapter



    }
    val allAhadeth = mutableListOf<Hadeth>()
    fun readSuraFile(fileName: String){
        val reader : String?= activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        if (reader == null) return;
        val hadethContent = reader.trim() .split("#")
        hadethContent.forEach {

            val title = it.trim().substringBefore("\n")
            val hadeth = it.trim().substringAfter("\n")
            hadethNames.add(" حديث رقم  "+number.toString())
            number++
            Log.e("Title",""+title)
            allAhadeth.add(Hadeth(title,hadeth))
        }

    }

}

