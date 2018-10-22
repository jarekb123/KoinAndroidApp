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

}