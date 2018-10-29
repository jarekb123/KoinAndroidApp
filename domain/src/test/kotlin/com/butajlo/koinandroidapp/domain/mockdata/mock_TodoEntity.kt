package com.butajlo.koinandroidapp.domain.mockdata

import com.butajlo.koinandroidapp.domain.entity.TodoEntity

fun mockTodoEntity(userId: Long) = TodoEntity(userId = userId, id = 1, title = "title", isCompleted = true)

fun mockListOfTodoEntity(userId: Long, size: Int): List<TodoEntity> {
    return mutableListOf<TodoEntity>().apply {
        for (i in 1..size) {
            add(mockTodoEntity(userId).copy(id = i.toLong()))
        }
    }
}