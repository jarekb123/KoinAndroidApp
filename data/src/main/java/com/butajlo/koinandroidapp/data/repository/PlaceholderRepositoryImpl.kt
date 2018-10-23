package com.butajlo.koinandroidapp.data.repository

import com.butajlo.koinandroidapp.data.mapper.toEntity
import com.butajlo.koinandroidapp.data.service.PlaceholderService
import com.butajlo.koinandroidapp.domain.entity.UserEntity
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import io.reactivex.Single

class PlaceholderRepositoryImpl(private val placeholderService: PlaceholderService) : PlaceholderRepository {
    override fun getUsers(): Single<List<UserEntity>>
            = placeholderService.getUsers().map { it.map { it.toEntity() } }

    override fun getUser(id: Long): Single<UserEntity>
            = placeholderService.getUser(id).map { it.toEntity() }

    override fun findUserByUsername(username: String): Single<List<UserEntity>>
            = placeholderService.findUserByUsername(username).map { it.map { it.toEntity() } }

}