package com.sping.baseproject.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sping.baseproject.model.dao.PostDao
import com.sping.baseproject.model.entity.Post

/**
 *  Room [Database]
 */
@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
}