package com.slavetny.myday.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slavetny.myday.R
import com.slavetny.myday.model.Algorithm
import kotlinx.android.synthetic.main.algorthm_item.view.*

class AlgorithmAdapter(var algorithmsList: List<Algorithm>) : RecyclerView.Adapter<AlgorithmAdapter.AlgorthmViewHolder>() {

    private var algorithmClickedListener: OnAlgorithmClickedListener? = null

    fun setOnAlgorithmClickedListener(a: OnAlgorithmClickedListener?) {
        algorithmClickedListener = a
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlgorthmViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.algorthm_item, parent, false)

        return AlgorthmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return algorithmsList.size
    }

    override fun onBindViewHolder(holder: AlgorthmViewHolder, position: Int) {
        holder.bind(algorithmsList.get(position), algorithmClickedListener!!)
    }

    class AlgorthmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //TODO fix bug with wrong color showing
        fun bind(algorithm: Algorithm, algorithmClickedListener: OnAlgorithmClickedListener) {
            itemView.algorithm_icon.setImageResource(algorithm.icon)

            itemView.setOnClickListener {
                if (algorithmClickedListener != null)
                    algorithmClickedListener.onAlgorithmClicked(algorithm)
            }
        }
    }

    interface OnAlgorithmClickedListener {
        fun onAlgorithmClicked(algorithm: Algorithm)
    }
}