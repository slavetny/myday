package com.slavetny.myday.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slavetny.myday.R
import com.slavetny.myday.model.Algorithm
import kotlinx.android.synthetic.main.algorthm_item.view.*

class AlgorithmAdapter(var algorithmsList: List<Algorithm>) : RecyclerView.Adapter<AlgorithmAdapter.AlgorthmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlgorthmViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.algorthm_item, parent, false)

        return AlgorthmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return algorithmsList.size
    }

    override fun onBindViewHolder(holder: AlgorthmViewHolder, position: Int) {
        holder.bind(algorithmsList.get(position))
    }

    class AlgorthmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //TODO fix bug with wrong color showing
        fun bind(algorithm: Algorithm) {
            itemView.algorithm_icon.setImageResource(algorithm.icon)
            itemView.algorithm_background.setBackgroundColor(algorithm.backgroundColor)
        }
    }
}