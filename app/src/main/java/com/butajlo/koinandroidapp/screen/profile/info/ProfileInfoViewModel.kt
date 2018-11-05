package com.butajlo.koinandroidapp.screen.profile.info

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.butajlo.koinandroidapp.domain.countAlbumsByUser
import com.butajlo.koinandroidapp.domain.countPostsByUser
import com.butajlo.koinandroidapp.domain.countTodosByUser
import com.butajlo.koinandroidapp.domain.randomPostByUser
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.butajlo.koinandroidapp.network.SessionManager
import com.butajlo.koinandroidapp.rx.execute
import com.butajlo.koinandroidapp.sharedbindings.CardPostBindingModel

class ProfileInfoViewModel(
    private val sessionManager: SessionManager,
    private val repository: PlaceholderRepository
) : ViewModel() {

    val infoBindingModel = MutableLiveData<ProfileInfoBindingModel>()
    val randomPostBindingModel = MutableLiveData<CardPostBindingModel>()

    init {
        infoBindingModel.value = ProfileInfoBindingModel()
        updatePostsCounter()
        updateTodosCounter()
        updateAlbumsCounter()
        updateRandomPost()
    }

    private fun updatePostsCounter() {
        countPostsByUser(repository = repository, userId = sessionManager.userId)
            .execute(
                onSuccess = { count ->
                    infoBindingModel.apply {
                        value = value?.copy(postsCount = count)
                    }
                },
                onError = { onError(it) }
            )
    }

    private fun updateAlbumsCounter() {
        countAlbumsByUser(repository = repository, userId = sessionManager.userId)
            .execute(
                onSuccess = { count ->
                    infoBindingModel.apply {
                        value = value?.copy(albumsCount = count)
                    }

                },
                onError = { onError(it) }
            )
    }

    private fun updateTodosCounter() {
        countTodosByUser(repository = repository, userId = sessionManager.userId)
            .execute(
                onSuccess = { count ->
                    infoBindingModel.apply {
                        value = value?.copy(todosCount = count)
                    }
                },
                onError = { onError(it) }
            )
    }

    private fun updateRandomPost() {
        randomPostByUser(repository = repository, userId = sessionManager.userId)
            .execute(
                onSuccess = {
                    randomPostBindingModel.value =
                            CardPostBindingModel(
                                id = it.id,
                                title = it.title,
                                content = it.body,
                                imageUrl = "https://picsum.photos/160/160/?random", // random 160x160 photo
                                isFavorite = false,
                                info = "Random Post"
                            )
                },
                onError = { onError(it) }
            )
    }

    private fun onError(throwable: Throwable) {
        Log.e(javaClass.simpleName, "Error during loading", throwable)
    }
}