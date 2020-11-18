package com.isbmobilecomputing.android

import android.app.Application

class ISBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationData.init(this)
    }
}