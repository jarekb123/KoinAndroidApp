package com.butajlo.koinandroidapp.domain.mockdata

import com.butajlo.koinandroidapp.domain.entity.AddressEntity
import com.butajlo.koinandroidapp.domain.entity.UserEntity

fun mockUserEntity(): UserEntity =
    UserEntity(
        id = 1,
        username = "username",
        name = "name",
        addressEntity = mockAddressEntity(),
        email = "email@email.com"
    )

fun mockAddressEntity(): AddressEntity =
    AddressEntity(
        street = "street",
        city = "city",
        lat = 0.0f,
        lng = 0.0f,
        suite = "suite",
        zipcode = "00000"
    )