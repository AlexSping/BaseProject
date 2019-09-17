package com.sping.baseproject.network

/**
 * Wrapper for data manipulation operations
 */
sealed class CallState<out T> {

    /**
     * Represents empty data state
     */
    class Empty<T> : CallState<T>()

    /**
     * Represents success state of the operation
     *
     * `
     * @param data of type [T] to be returned
     */
    data class Success<T>(val data: T) : CallState<T>()

    data class Error<T> constructor(
        val message: String? = null,
        val code: Int? = null,
        val throwable: Throwable? = null
    ) : CallState<T>()

}