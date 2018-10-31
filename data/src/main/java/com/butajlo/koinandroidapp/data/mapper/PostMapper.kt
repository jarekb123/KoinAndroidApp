package com.butajlo.koinandroidapp.data.mapper

import com.butajlo.koinandroidapp.data.model.PostData

fun PostData.toEntity(isFavorite: Boolean = false) = PostEntity(userId, id, title, body, isFavorite)

fun PostEntity.toData() = PostData(userId, id, title, body)

fun PostEntity.toPersistentEntity() = com.butajlo.koinandroidapp.persistence.likedpost.PostEntity(id, userId)