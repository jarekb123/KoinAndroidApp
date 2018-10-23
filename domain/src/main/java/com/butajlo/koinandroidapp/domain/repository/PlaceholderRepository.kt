package com.butajlo.koinandroidapp.domain.repository

import com.butajlo.koinandroidapp.domain.entity.UserEntity
import io.reactivex.Single

interface PlaceholderRepository {
    /**
     * @return List of users
     */
    fun getUsers(): Single<List<UserEntity>>

    /**
     * @param id User's id
     * @return UserEntity related to provided [id]
     */
    fun getUser(id: Long): Single<UserEntity>

    /**
     * @param username User's username who is wanted to find
     * @return List of found users with provided [username]. The list should contain one or none user.
     */
    fun findUserByUsername(username: String): Single<List<UserEntity>>

}