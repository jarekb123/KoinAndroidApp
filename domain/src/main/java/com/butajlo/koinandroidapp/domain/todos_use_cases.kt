package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import io.reactivex.Single

fun countTodosByUser(repository: PlaceholderRepository, userId: Long): Single<Int> =
    repository
        .findTodosForUser(userId)
        .map { it.size }


fun findTodosByUser(repository: PlaceholderRepository, userId: Long) = repository.findTodosForUser(userId)