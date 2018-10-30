package com.butajlo.koinandroidapp.ui.sharedbindings

data class CardPostBindingModel(
    val id: Long,
    val title: String,
    val content: String,
    val imageUrl: String,
    val isFavorite: Boolean = false,
    val info: String = ""
)