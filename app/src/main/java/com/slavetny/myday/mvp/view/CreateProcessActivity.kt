package com.slavetny.myday.mvp.view

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.slavetny.myday.R
import com.slavetny.myday.adapter.AlgorithmAdapter
import com.slavetny.myday.model.Algorithm
import kotlinx.android.synthetic.main.activity_create_process.*
import kotlinx.android.synthetic.main.new_process_dialog.recyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CreateProcessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_process)

        setupRecyclerView()

        timePick1.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)


                    time1.text = "Time from: " + SimpleDateFormat("HH:mm").format(cal.time)
                }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        timePick2.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)


                    time2.text = "Time to: " + SimpleDateFormat("HH:mm").format(cal.time)
                }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        //TODO create a database for returned processes
        create_process.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        var algorithmsList = ArrayList<Algorithm>()
        algorithmsList.add(Algorithm("volume",
            R.drawable.ic_volume_off
        ))

        var linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManager

        var algorithmAdapter = AlgorithmAdapter(algorithmsList)

        recyclerView.adapter = algorithmAdapter

        algorithmAdapter.setOnAlgorithmClickedListener(object: AlgorithmAdapter.OnAlgorithmClickedListener {
            override fun onAlgorithmClicked(algorithm: Algorithm) {
                Toast.makeText(this@CreateProcessActivity, algorithm.tag, Toast.LENGTH_SHORT).show()
            }
        })
    }

    interface OnProcessCreateClickedListener {
        fun onProcessCreateClicked(algorithm: Algorithm)
    }
}
