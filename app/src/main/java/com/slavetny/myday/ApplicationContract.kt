package com.slavetny.myday

interface ApplicationContract {

    interface Model {
        interface OnFinishedListener {
            fun onFinished()

            fun onFailure(t: Throwable?)
        }

        fun getAllProcess()
    }

    interface View {
        fun addProcess()

        fun showProcess()
    }

    interface Presenter {
        fun loadProcess()
    }
}