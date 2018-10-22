package com.butajlo.koinandroidapp.domain.entity

data class UserEntity(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val addressEntity: AddressEntity
)

data class AddressEntity(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val lat: Float,
    val lng: Float
)