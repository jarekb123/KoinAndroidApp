package com.butajlo.koinandroidapp.data.mapper

import com.butajlo.koinandroidapp.data.model.TodoData
import com.butajlo.koinandroidapp.domain.entity.TodoEntity

fun TodoData.toEntity() = TodoEntity(userId = userId, id = id, title = title, isCompleted = completed)