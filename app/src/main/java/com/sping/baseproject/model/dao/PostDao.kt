package com.sping.baseproject.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sping.baseproject.model.database.AppDatabase
import com.sping.baseproject.model.entity.Post

/**
 * [Dao] class for [Post] objects
 */
@Dao
interface PostDao {

    /**
     * Inserts a [List] of [Post]s to the [AppDatabase]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(posts: List<Post>): LongArray

    /**
     * Queries all [Post]s from the [AppDatabase]
     */
    @Query("SELECT * FROM posts")
    suspend fun getPosts(): List<Post>
}