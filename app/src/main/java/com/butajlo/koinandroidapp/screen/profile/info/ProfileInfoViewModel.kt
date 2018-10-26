package com.butajlo.koinandroidapp.screen.profile.info

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.butajlo.koinandroidapp.domain.countPostsByUser
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.butajlo.koinandroidapp.network.SessionManager
import com.butajlo.koinandroidapp.rx.execute

class ProfileInfoViewModel(
    sessionManager: SessionManager,
    repository: PlaceholderRepository
) : ViewModel() {

    val dataBindingModel = MutableLiveData<ProfileInfoBindingModel>()

    init {
        dataBindingModel.value = ProfileInfoBindingModel()
        countPostsByUser(repository = repository, userId = sessionManager.userId)
            .execute(
                onSuccess = { count ->
                    dataBindingModel.apply {
                        value = value?.copy(postsCount = count)
                    }
                },
                onError = { onError(it, -1) }
            )
    }

    private fun onError(throwable: Throwable, errorRes: Int) {
        Log.e(javaClass.simpleName, "Error during loading", throwable)
    }
}