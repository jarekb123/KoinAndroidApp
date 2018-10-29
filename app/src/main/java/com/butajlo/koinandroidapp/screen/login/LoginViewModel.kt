package com.butajlo.koinandroidapp.screen.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.domain.entity.UserEntity
import com.butajlo.koinandroidapp.domain.loginUser
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.butajlo.koinandroidapp.rx.execute
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class LoginViewModel(private val repository: PlaceholderRepository) : ViewModel() {

    private val subscriptions = CompositeDisposable()

    val loggedInUser = MutableLiveData<UserEntity>()
    val usernameFieldErrorRes = MutableLiveData<Int>()
    val passwordFieldErrorRes = MutableLiveData<Int>()

    override fun onCleared() {
        subscriptions.clear()
    }

    fun login(username: String, password: String) {
        loginUser(repository, username).execute(
            onSuccess = { loggedInUser.value = it },
            onError = {
                loggedInUser.value = null
                Log.e(javaClass.simpleName, "Error during user login", it)
            }
        ).addTo(subscriptions)
    }

    fun validateUsername(username: String) {
        if (username.isEmpty()) {
            usernameFieldErrorRes.value = R.string.username_field_empty
        }
    }

    fun validatePassword(password: String) {
        if(password.isEmpty()) {
            passwordFieldErrorRes.value = R.string.password_field_empty
        }
    }
}