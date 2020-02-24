package com.slavetny.myday.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slavetny.myday.R


class ProcessAdapter : RecyclerView.Adapter<ProcessAdapter.ProcessViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProcessViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.process_item, parent, false)

        return ProcessViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: ProcessViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount - 1) 1 else 2
    }

    class ProcessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {

        }

    }
}