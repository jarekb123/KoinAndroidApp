package com.butajlo.koinandroidapp.domain.entity

data class TodoEntity(
    val userId: Long,
    val id: Long,
    val title: String,
    val isCompleted: Boolean
)