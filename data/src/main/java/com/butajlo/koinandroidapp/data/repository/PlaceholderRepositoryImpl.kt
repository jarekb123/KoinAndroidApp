package com.butajlo.koinandroidapp.data.repository

import com.butajlo.koinandroidapp.data.mapper.toEntity
import com.butajlo.koinandroidapp.data.service.PlaceholderService
import com.butajlo.koinandroidapp.domain.entity.AlbumEntity
import com.butajlo.koinandroidapp.domain.entity.PostEntity
import com.butajlo.koinandroidapp.domain.entity.TodoEntity
import com.butajlo.koinandroidapp.domain.entity.UserEntity
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.butajlo.koinandroidapp.persistence.db.AppDatabase
import io.reactivex.Single

class PlaceholderRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val appDatabase: AppDatabase
) : PlaceholderRepository {
    override fun getUsers(): Single<List<UserEntity>> = placeholderService.getUsers().map { it.map { it.toEntity() } }

    override fun getUser(id: Long): Single<UserEntity> = placeholderService.getUser(id).map { it.toEntity() }

    override fun findUserByUsername(username: String): Single<List<UserEntity>> =
        placeholderService.findUserByUsername(username).map { it.map { it.toEntity() } }

    override fun findPostsByUserId(userId: Long): Single<List<PostEntity>> =
        placeholderService.findPostsByUserId(userId).map {
            it.map {
                it.toEntity()
            }
        }

    override fun findTodosForUser(userId: Long): Single<List<TodoEntity>> =
        placeholderService.findTodosByUserId(userId).map { it.map { it.toEntity() } }

    override fun findAlbumsByUserId(userId: Long): Single<List<AlbumEntity>> =
        placeholderService.findAlbumsByUserId(userId).map { it.map { it.toEntity() } }
}