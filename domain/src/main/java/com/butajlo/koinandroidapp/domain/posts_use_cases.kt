package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository

/**
 * Count Articles By User Use Case
 *
 * @param repository Provides data
 * @param userId User's id
 * @return Number of posts written by user with provided [userId]
 */
fun countPostsByUser(repository: PlaceholderRepository, userId: Long) =
    repository
        .findPostsByUserId(userId)
        .map { it.size }
