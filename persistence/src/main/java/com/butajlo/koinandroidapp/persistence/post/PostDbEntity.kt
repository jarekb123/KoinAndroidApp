package com.butajlo.koinandroidapp.persistence.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostDbEntity(

    @PrimaryKey
    @ColumnInfo(name = "_id")
    val id: Long,

    @ColumnInfo(name = "user_id")
    val userId: Long,

    val title: String,

    val content: String,

    @ColumnInfo(name = "favorite")
    val isFavorite: Boolean
)