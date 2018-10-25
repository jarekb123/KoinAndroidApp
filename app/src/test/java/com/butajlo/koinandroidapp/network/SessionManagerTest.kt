package com.butajlo.koinandroidapp.network

import org.junit.Before
import org.junit.Test

class SessionManagerTest {

    private lateinit var sessionManager: SessionManager

    @Before
    fun setup() {
        sessionManager = SessionManager()
    }

    @Test
    fun isLoggedIn_FirstInit_ShouldReturnFalse() {
        assert(!sessionManager.isLoggedIn())
    }

    @Test
    fun isLoggedIn_Login_ShouldReturnTrue() {
        sessionManager.login(1)
        assert(sessionManager.isLoggedIn())
    }

    @Test
    fun isLoggedIn_LoginThenLogout_ShouldReturnFalse() {
        sessionManager.login(1)
        sessionManager.logout()
        assert(!sessionManager.isLoggedIn())
    }

    @Test(expected = NotLoggedInException::class)
    fun getLoginTime_NotLoggedIn_ShouldThrowException() {
        sessionManager.loginTime
    }

}