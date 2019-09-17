package com.sping.baseproject.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.sping.baseproject.di.extra.AppScope
import com.sping.baseproject.model.BASE_URL
import com.sping.baseproject.network.PostsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import java.util.concurrent.TimeUnit


/**
 * [Module] that satisfies [Retrofit] dependencies
 */
@Module
object NetworkModule {

    /**
     * Provides [PostsApi] dependency
     */
    @AppScope
    @Provides
    @JvmStatic
    internal fun provideApi(retrofit: Retrofit): PostsApi {
        return retrofit.create(PostsApi::class.java)
    }

    /**
     * Provides [Retrofit] dependency
     */
    @AppScope
    @Provides
    @JvmStatic
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    /**
     * Provides [OkHttpClient] dependency
     */
    @AppScope
    @Provides
    @JvmStatic
    internal fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    /**
     * Provides [HttpLoggingInterceptor] dependency
     */
    @AppScope
    @Provides
    @JvmStatic
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = Level.BODY
        return logging
    }

}