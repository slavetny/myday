package com.slavetny.myday.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.slavetny.myday.ApplicationContract
import com.slavetny.myday.R
import com.slavetny.myday.mvp.presenter.ProcessPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ApplicationContract.View {

    private var presenter: ProcessPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ProcessPresenter()

        showProcess()
    }

    //TODO make showProcess() method logic
    override fun showProcess() {
        recyclerView
    }
}
