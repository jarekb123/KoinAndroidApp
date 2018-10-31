package com.butajlo.koinandroidapp.screen.profile.myposts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.butajlo.koinandroidapp.domain.getPostsByUser
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.butajlo.koinandroidapp.network.SessionManager
import com.butajlo.koinandroidapp.rx.execute
import com.butajlo.koinandroidapp.sharedbindings.CardPostBindingModel
import com.butajlo.koinandroidapp.sharedbindings.toBindingModel

class MyPostsViewModel(
    private val repository: PlaceholderRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    val myPosts = MutableLiveData<List<CardPostBindingModel>>()

    init {
        getMyPosts()
    }

    private fun getMyPosts() {
        getPostsByUser(repository = repository, userId = sessionManager.userId)
            .execute(
                onSuccess = { myPosts.value = it.map { it.toBindingModel() } },
                onError = { onError(it) }
            )
    }

    private fun onError(throwable: Throwable) {
        Log.e(javaClass.simpleName, "error", throwable)
    }

}