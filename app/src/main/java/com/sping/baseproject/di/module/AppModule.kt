package com.sping.baseproject.di.module

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.sping.baseproject.di.extra.AppScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * [Module] that satisfies [Application] and [Glide] dependencies
 */
@Module
class AppModule {

    /**
     * Provides [Context] dependency
     */
    @Provides
    @AppScope
    fun bindContext(application: Application): Context {
        return application.applicationContext
    }

    /**
     * Provides [Glide] dependency
     */
    @Provides
    @AppScope
    fun provideGlide(application: Application): RequestManager {
        return Glide.with(application)
    }
}