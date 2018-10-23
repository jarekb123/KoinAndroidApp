package com.butajlo.koinandroidapp.domain

import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository

fun getUsers(repository: PlaceholderRepository) = repository.getUsers()

fun getUser(repository: PlaceholderRepository, id: Long) = repository.getUser(id)

fun loginUser(repository: PlaceholderRepository, username: String) {

}