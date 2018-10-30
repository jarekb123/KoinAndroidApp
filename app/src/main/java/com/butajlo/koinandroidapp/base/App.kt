package com.butajlo.koinandroidapp.base

import android.app.Application
import com.butajlo.koinandroidapp.di.getAppModules
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, getAppModules())
    }
}