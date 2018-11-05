package com.butajlo.koinandroidapp.persistence.post

import androidx.room.*
import io.reactivex.Single

@Dao
interface PostDbDao {

    @Insert
    fun insert(post: PostDbEntity)

    @Query("SELECT * FROM post ORDER BY _id")
    fun getPosts(): Single<List<PostDbEntity>>

    @Query("SELECT * FROM post WHERE user_id = :userId")
    fun getPostsByUser(userId: Long): Single<List<PostDbEntity>>

    @Query("SELECT COUNT(*) FROM post WHERE user_id = :userId")
    fun countPostsByUser(userId: Long): Single<Int>

    @Update
    fun updatePost(post: PostDbEntity)

    @Query("DELETE FROM post")
    fun deleteAllFavoritePosts()

}