package com.butajlo.koinandroidapp.screen.login

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val loginModule = module {
    viewModel { LoginViewModel(get()) }
}
