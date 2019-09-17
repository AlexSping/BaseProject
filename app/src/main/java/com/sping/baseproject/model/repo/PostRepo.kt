package com.sping.baseproject.model.repo

import com.sping.baseproject.model.dao.PostDao
import com.sping.baseproject.model.entity.Post
import com.sping.baseproject.network.CallState
import com.sping.baseproject.network.PostsApi
import com.sping.baseproject.utils.network.request
import javax.inject.Inject

/**
 * Repository class for [Post] objects
 */
class PostRepo @Inject constructor(
    private val postsApi: PostsApi,
    private val postDao: PostDao
) {

    /**
     * Queries [PostDao] for [Post]s and if no [Post]s are found it requests them from the [PostsApi]
     *
     * @return a [List] of [Post] wrapped within a [CallState]
     */
    suspend fun getPosts(): CallState<List<Post>> {
        val posts = postDao.getPosts()
        return if (posts.isNullOrEmpty())
            request { postsApi.getPosts() }.apply {
                when (this) {
                    is CallState.Success -> postDao.insertPost(this.data)
                }
            }
        else CallState.Success(posts)
    }
}