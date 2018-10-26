package com.butajlo.koinandroidapp.screen.profile.info

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val profileInfoModule = module {
    viewModel { ProfileInfoViewModel(get(), get()) }
}