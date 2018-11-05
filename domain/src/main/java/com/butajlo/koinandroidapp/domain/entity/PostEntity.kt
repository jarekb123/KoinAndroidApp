package com.butajlo.koinandroidapp.domain.entity

data class PostEntity(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String,
    val thumbnailUrl: String,
    val imageUrl: String
)
