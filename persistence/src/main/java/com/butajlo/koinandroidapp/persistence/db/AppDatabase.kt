package com.butajlo.koinandroidapp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.butajlo.koinandroidapp.persistence.post.PostDbDao
import com.butajlo.koinandroidapp.persistence.post.PostDbEntity

@Database(entities = [PostDbEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoritePostsDao(): PostDbDao

    companion object {

        var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if(INSTANCE == null) {
                synchronized(AppDatabase::class) {
                     INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "post_db").build()
                }
            }
            return INSTANCE
        }

        fun destroy() {
            INSTANCE = null
        }
    }

}