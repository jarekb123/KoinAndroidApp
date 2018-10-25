package com.butajlo.koinandroidapp.network

import java.util.*


class SessionManager {

    var loginTime: Calendar = Calendar.getInstance()
        private set
        get() {
            if(isLoggedIn()) {
                return field
            } else {
                throw NotLoggedInException("User is not logged in. You can't get login time.")
            }
        }

    private var userId = -1L

    fun isLoggedIn() = userId != -1L

    fun login(userId: Long) {
        this.userId = userId
        loginTime = Calendar.getInstance()
    }

    fun logout() {
        userId = -1L
    }
}

class NotLoggedInException(override val message: String? = null) : Exception(message)