package com.sping.baseproject.network

import android.database.Observable
import com.sping.baseproject.model.entity.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface PostsApi {

    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

}