package com.example.tokopen.domain.common

sealed class BaseResult<out T: Any, out U: Any> {
    data class Success<T: Any>(val data: T): BaseResult<T, Nothing>()
    data class Error<U: Any>(val message: U): BaseResult<Nothing, U>()
}
