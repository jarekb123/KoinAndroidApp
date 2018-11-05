package com.butajlo.koinandroidapp.data.mapper

import com.butajlo.koinandroidapp.data.model.PostData
import com.butajlo.koinandroidapp.domain.entity.PostEntity

fun PostData.toEntity(isFavorite: Boolean = false) = PostEntity(userId, id, title, body, isFavorite)

fun PostEntity.toData() = PostData(userId, id, title, body)
