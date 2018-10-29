package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.entity.PostEntity
import com.butajlo.koinandroidapp.domain.ext.random
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import io.reactivex.Single

/**
 * Count Articles By User Use Case
 *
 * @param repository Provides data
 * @param userId User's id
 * @return Number of posts written by user with provided [userId]
 */
fun countPostsByUser(repository: PlaceholderRepository, userId: Long): Single<Int> =
    repository
        .findPostsByUserId(userId)
        .map { it.size }

/**
 * Random Post By User Use Case
 *
 * @param repository Provides data
 * @param userId User's id
 * @return Random post written by user with provided [userId]
 */
fun randomPostByUser(repository: PlaceholderRepository, userId: Long): Single<PostEntity> =
        repository
            .findPostsByUserId(userId)
            .map { it.random() }