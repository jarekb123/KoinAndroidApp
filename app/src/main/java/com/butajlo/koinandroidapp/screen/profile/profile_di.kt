package com.butajlo.koinandroidapp.screen.profile

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val profileModule = module {
    viewModel { ProfileViewModel(get()) }
}