package com.route.islami.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R

class HadethNameAdapter (val items: List<String> ) : RecyclerView.Adapter<HadethNameAdapter.ViewHolder>(){
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val  hadethName = itemView.findViewById<TextView>(R.id.HadethNameTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_hadeth_item_name,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hadethName.text = items.get(position)
        holder.hadethName.setOnClickListener {
            onItemClick?.onHadethNameClick(items.get(position),position)
        }
    }
    var onItemClick : OnItemClick?= null
    interface OnItemClick{
        fun onHadethNameClick(sura:String, postion: Int)
    }

    override fun getItemCount(): Int {
        return  items.size
    }
}