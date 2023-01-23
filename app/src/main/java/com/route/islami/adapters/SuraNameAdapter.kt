package com.route.islami.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R

class SuraNameAdapter(val items: List<String> ) :RecyclerView.Adapter<SuraNameAdapter.ViewHolder>(){
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val  suraNameTv = itemView.findViewById<TextView>(R.id.suraNameTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_item_sura_name,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suraNameTv.text = items.get(position)
        holder.suraNameTv.setOnClickListener {
            onItemClick?.onSuraNameClick(items.get(position),position)
        }
    }
    var onItemClick : OnItemClick?= null
    interface OnItemClick{
        fun onSuraNameClick(sura:String, postion: Int)
    }

    override fun getItemCount(): Int {
        return  items.size
    }
}