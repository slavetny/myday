package com.slavetny.myday.mvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.slavetny.myday.ApplicationContract
import com.slavetny.myday.R
import com.slavetny.myday.adapter.ProcessAdapter
import com.slavetny.myday.mvp.presenter.ProcessPresenter
import kotlinx.android.synthetic.main.activity_main.*

//TODO create model for process

class MainActivity : AppCompatActivity(), ApplicationContract.View {

    private var presenter: ProcessPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ProcessPresenter()

        showProcess()

        new_process_btn.setOnClickListener {
            addProcess()
        }
    }

    override fun addProcess() {
        startActivity(Intent(this, CreateProcessActivity::class.java))
    }

    override fun showProcess() {
        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = ProcessAdapter()
    }
}
