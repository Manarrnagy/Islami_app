package com.route.islami.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R
import com.route.islami.adapters.HadethNameAdapter
import com.route.islami.adapters.SuraNameAdapter
import com.route.islami.sura_details.SuraDetailsActivity

class AhadethFragment : Fragment() {

    lateinit var adapter: HadethNameAdapter
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
        adapter = SuraNameAdapter(suraNames)
        adapter.onItemClick = object : SuraNameAdapter.OnItemClick{
            override fun onSuraNameClick(sura: String, postion: Int) {
                val fileName = "${postion+1}.txt"
                val intent = Intent(requireActivity(), SuraDetailsActivity::class.java)
                intent.putExtra("fileName","${postion+1}.txt")
                intent.putExtra("suraName",sura)
                startActivity(intent)
            }
        }
        recyclerView.adapter = adapter
    }
}