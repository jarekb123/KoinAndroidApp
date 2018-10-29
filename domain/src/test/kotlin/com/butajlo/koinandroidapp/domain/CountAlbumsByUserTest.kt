package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.entity.AlbumEntity
import com.butajlo.koinandroidapp.domain.mockdata.mockListOfAlbumEntity
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class CountAlbumsByUserTest {

    private val repository = mock<PlaceholderRepository>()

    private val userId = 1L
    private val mockListOfAlbums = mockListOfAlbumEntity(userId = userId, size = 5)
    private val emptyListOfAlbums = emptyList<AlbumEntity>()

    @Test
    fun countAlbumsByUser_TakeNonEmptyListOfAlbums_ShouldReturnSizeOfList() {
        whenever(repository.findAlbumsByUserId(userId)).thenReturn(Single.just(mockListOfAlbums))
        countAlbumsByUser(repository, userId).test().assertValue(mockListOfAlbums.size)
    }

    @Test
    fun countAlbumsByUser_TakeEmptyListOfAlbums_ShouldReturnZero() {
        whenever(repository.findAlbumsByUserId(userId)).thenReturn(Single.just(emptyListOfAlbums))
        countAlbumsByUser(repository, userId).test().assertValue(0)
    }
}