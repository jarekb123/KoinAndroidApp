package com.butajlo.koinandroidapp.di

import com.butajlo.koinandroidapp.network.networkModule
import com.butajlo.koinandroidapp.network.sessionModule
import com.butajlo.koinandroidapp.ui.uiModule

object AppModule {

    fun getModules() = listOf(
        networkModule, // Defines Network dependencies
        sessionModule, // Defines user session related dependencies
        viewModelModules, // Defines view models used in app
        uiModule // Defines UI related dependencies
    )

}