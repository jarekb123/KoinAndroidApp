package com.butajlo.koinandroidapp.ui

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val uiModule = module {
    factory { DebugPreferences(androidContext()) }
    factory { DebugActivityInterceptor(get()) as ActivityInterceptor }
}