package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import io.reactivex.Single

/**
 * Get Users Use Case
 *
 * @param repository [PlaceholderRepository] which provides data
 * @return List of all users
 */
fun getUsers(repository: PlaceholderRepository) = repository.getUsers()

/**
 * Login User Use Case
 *
 * @param repository [PlaceholderRepository] which provides data
 * @param username User's username, who wants to login to the service
 * @return true if user is logged in, false otherwise
 */
fun loginUser(repository: PlaceholderRepository, username: String): Single<Boolean> {
    return repository
        .findUserByUsername(username)
        .map {
            it.any { it.username == username }
        }
}