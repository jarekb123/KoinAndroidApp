package com.butajlo.koinandroidapp.data.mapper

import com.butajlo.koinandroidapp.data.model.AddressData
import com.butajlo.koinandroidapp.data.model.UserData
import com.butajlo.koinandroidapp.domain.entity.AddressEntity
import com.butajlo.koinandroidapp.domain.entity.UserEntity

fun UserData.toEntity() = UserEntity(id, name, username, email, address.toEntity())

fun AddressData.toEntity() = AddressEntity(street, suite, city, zipcode, geo.lat, geo.lng)