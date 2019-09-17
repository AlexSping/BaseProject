package com.sping.baseproject.utils.network

import com.sping.baseproject.network.CallState
import retrofit2.Response
import java.lang.Exception

suspend fun <T> request(apiRequest: suspend () -> Response<T>): CallState<T> {
    try {
        val response: Response<T> = apiRequest()
        when (response.isSuccessful) {
            true -> {
                val body: T = response.body() ?: return CallState.Empty()
                return CallState.Success(body)
            }
            false -> return CallState.Error(code = response.code())
        }
    } catch (e: Exception) {
        return CallState.Error(throwable = e)
    }
}