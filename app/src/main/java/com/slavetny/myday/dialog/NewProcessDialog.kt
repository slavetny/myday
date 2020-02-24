package com.slavetny.myday.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import com.slavetny.myday.R
import com.slavetny.myday.adapter.AlgorithmAdapter
import com.slavetny.myday.model.Algorithm
import kotlinx.android.synthetic.main.new_process_dialog.recyclerView

class NewProcessDialog(context: Context) : Dialog(context), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.new_process_dialog)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        var algorithmsList = ArrayList<Algorithm>()
        algorithmsList.add(Algorithm("volume", R.color.colorPrimary, R.drawable.ic_volume_off))
        algorithmsList.add(Algorithm("volume", R.color.colorAccent, R.drawable.ic_volume_off))
        algorithmsList.add(Algorithm("volume", R.color.orange, R.drawable.ic_volume_off))

        var linearLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = AlgorithmAdapter(algorithmsList)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            else -> {
                dismiss()
            }
        }
    }
}