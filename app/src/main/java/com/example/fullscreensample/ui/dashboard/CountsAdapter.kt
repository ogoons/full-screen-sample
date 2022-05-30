package com.example.fullscreensample.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fullscreensample.R

class CountsAdapter(
    var items: ArrayList<Int>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CountsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout_counts, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CountsViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CountsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            val tvCount = itemView.findViewById<TextView>(R.id.tv_count)
            tvCount.text = items[adapterPosition].toString()
        }
    }
}