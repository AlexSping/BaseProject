package com.sping.baseproject.di.module

import android.app.Application
import androidx.room.Dao
import androidx.room.Room
import com.sping.baseproject.di.extra.AppScope
import com.sping.baseproject.model.dao.PostDao
import com.sping.baseproject.model.database.AppDatabase
import dagger.Module
import dagger.Provides

/**
 * [Module] that satisfies [AppDatabase] and [Dao] dependencies
 */
@Module
class DatabaseModule {

    /**
     * Provides [AppDatabase] dependency
     */
    @AppScope
    @Provides
    internal fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "test.db").build()
    }

    /**
     * Provides [PostDao] dependency
     */
    @AppScope
    @Provides
    internal fun providePostDao(appDatabase: AppDatabase): PostDao {
        return appDatabase.postDao()
    }
}