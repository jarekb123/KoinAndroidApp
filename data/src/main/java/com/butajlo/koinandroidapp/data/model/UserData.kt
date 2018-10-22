package com.butajlo.koinandroidapp.data.model

data class UserData(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressData
)

data class AddressData(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: LatLngData
)

data class LatLngData(
    val lat: Float,
    val lng: Float
)