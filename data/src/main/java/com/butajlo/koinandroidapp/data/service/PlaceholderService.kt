package com.butajlo.koinandroidapp.data.service

import com.butajlo.koinandroidapp.data.model.UserData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlaceholderService {

    @GET("users")
    fun getUsers(): Single<List<UserData>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Long): Single<UserData>

    @GET("users")
    fun findUserByUsername(@Query("username") username: String): Single<List<UserData>>

}