package com.butajlo.koinandroidapp.domain.mockdata

import com.butajlo.koinandroidapp.domain.entity.AlbumEntity

fun mockAlbumEntity(userId: Long) = AlbumEntity(userId = userId, id = 1, title = "title")

fun mockListOfAlbumEntity(userId: Long, size: Int): List<AlbumEntity> {
    return mutableListOf<AlbumEntity>().apply {
        for (i in 1..size) {
            add(mockAlbumEntity(userId).copy(id = i.toLong()))
        }
    }
}