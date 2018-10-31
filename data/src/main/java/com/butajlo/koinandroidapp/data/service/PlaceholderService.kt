package com.butajlo.koinandroidapp.data.service

import com.butajlo.koinandroidapp.data.model.AlbumData
import com.butajlo.koinandroidapp.data.model.PostData
import com.butajlo.koinandroidapp.data.model.TodoData
import com.butajlo.koinandroidapp.data.model.UserData
import io.reactivex.Single
import retrofit2.http.*

interface PlaceholderService {

    @GET("users")
    fun getUsers(): Single<List<UserData>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Long): Single<UserData>

    @GET("users")
    fun findUserByUsername(@Query("username") username: String): Single<List<UserData>>

    @GET("posts")
    fun findPostsByUserId(@Query("userId") userId: Long): Single<List<PostData>>

    @PUT("posts/{id}")
    fun updatePost(@Body postData: PostData, postId: Long): Single<PostData>

    @GET("users/{id}/todos")
    fun findTodosByUserId(@Path("id") userId: Long): Single<List<TodoData>>

    @GET("users/{id}/albums")
    fun findAlbumsByUserId(@Path("id") userId: Long): Single<List<AlbumData>>

}