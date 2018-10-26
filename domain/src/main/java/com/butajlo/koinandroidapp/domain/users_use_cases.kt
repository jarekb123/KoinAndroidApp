package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.entity.UserEntity
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import io.reactivex.Single
import io.reactivex.exceptions.Exceptions

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
fun loginUser(repository: PlaceholderRepository, username: String): Single<UserEntity> {
    return repository
        .findUserByUsername(username)
        .map {
            try {
                it.first()
            } catch (e: Exception) {
                throw Exceptions.propagate(e)
            }
        }
}

/**
 * Get User By Id Use Case
 *
 * @param repository [PlaceholderRepository] which provides data
 * @param userId User's id
 * @return UserEntity with provided [userId]
 */
fun getUserById(repository: PlaceholderRepository, userId: Long) = repository.getUser(userId)