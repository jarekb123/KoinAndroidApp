package com.butajlo.koinandroidapp.screen.profile

import androidx.lifecycle.ViewModel
import com.butajlo.koinandroidapp.network.SessionManager

class ProfileViewModel(private val sessionManager: SessionManager) : ViewModel() {

    fun login(userId: Long) = sessionManager.login(userId)
}