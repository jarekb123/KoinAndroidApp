package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository

fun countAlbumsByUser(repository: PlaceholderRepository, userId: Long) =
        repository
            .findAlbumsByUserId(userId)
            .map { it.size }