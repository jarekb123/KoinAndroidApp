package com.butajlo.koinandroidapp.di

import com.butajlo.koinandroidapp.screen.login.LoginViewModel
import com.butajlo.koinandroidapp.screen.profile.ProfileViewModel
import com.butajlo.koinandroidapp.screen.profile.info.ProfileInfoViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Setup Koin DSL for view models used in the App
 */
val viewModelModules = module {
    viewModel { ProfileViewModel(get()) }

    // Profile Screen
    viewModel { LoginViewModel(get()) }
    viewModel { ProfileInfoViewModel(get(), get()) }

}