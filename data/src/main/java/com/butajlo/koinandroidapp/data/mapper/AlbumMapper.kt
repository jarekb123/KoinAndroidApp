package com.butajlo.koinandroidapp.data.mapper

import com.butajlo.koinandroidapp.data.model.AlbumData
import com.butajlo.koinandroidapp.domain.entity.AlbumEntity

fun AlbumData.toEntity() = AlbumEntity(userId = userId, id = id, title = title)