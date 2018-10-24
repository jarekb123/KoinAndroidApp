package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.mockdata.mockUserEntity
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test


class LoginUserTest {


    private val repository = mock<PlaceholderRepository>()
    private val mockUser = mockUserEntity()


    private fun loginUser() = loginUser(repository, mockUser.username)

    @Test
    fun loginUser_RepoEmptyList_SingleShouldReturnFalse() {
        whenever(repository.findUserByUsername(any())).thenReturn(Single.just(emptyList()))
        loginUser().test().assertValue(false)
    }

    @Test
    fun loginUser_RepoNonEmptyList_SingleShouldReturnTrue() {
        whenever(repository.findUserByUsername(mockUser.username)).thenReturn(Single.just(listOf(mockUser)))
        loginUser().test().assertValue(true)
    }
}