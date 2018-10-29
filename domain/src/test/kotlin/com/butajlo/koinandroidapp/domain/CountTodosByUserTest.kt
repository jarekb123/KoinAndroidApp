package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.entity.TodoEntity
import com.butajlo.koinandroidapp.domain.mockdata.mockListOfTodoEntity
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class CountTodosByUserTest {

    private val repository = mock<PlaceholderRepository>()
    private val userId = 1L
    private val listOfTodos = mockListOfTodoEntity(userId = userId, size = 5)
    private val emptyListOfTodos = emptyList<TodoEntity>()

    @Test
    fun countTodosByUser_TakeListOfTodos_ShouldReturnSizeOfList() {
        whenever(repository.findTodosForUser(userId)).thenReturn(Single.just(listOfTodos))
        countTodosByUser(repository, userId).test().assertValue(listOfTodos.size)
    }

    @Test
    fun countTodosByUser_TakeEmptyList_ShouldReturnZero() {
        whenever(repository.findTodosForUser(userId)).thenReturn(Single.just(emptyListOfTodos))
        countTodosByUser(repository, userId).test().assertValue(0)
    }

}