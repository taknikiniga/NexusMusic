package com.player.music.mp3.datasource.util.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    data class Success<T>(var datas: T) : Resource<T>(datas)
    data class Loading<T>(var datas: T? = null) : Resource<T>(datas)
    data class Error<T>(var throwable: Throwable, var datas: T? = null) : Resource<T>(datas, throwable)
}

fun <T, R> Resource<T>.map(transform: (List<T>) -> List<R>): Resource<T> {
    return when (this) {

        is Resource.Error -> {
            Resource.Error(throwable = throwable, datas = datas)
        }
        is Resource.Loading -> {
            Resource.Loading(datas)
        }
        is Resource.Success -> {
            Resource.Success(datas)
        }
    }
}

fun <T> Flow<Resource<T>>.doOnSuccess(action:suspend (T?)->Unit): Flow<Resource<T>> = transform { result ->
    if (result is Resource.Success){
        action(result.data)
    }
    return@transform emit(result)
}

fun <T> Flow<Resource<T>>.doOnFailure(action: suspend (Throwable?, T?) -> Unit): Flow<Resource<T>> = transform { result ->
    if (result is Resource.Error){
        action(result.error,result.data)
    }
    return@transform emit(result)

}

fun <T> Flow<Resource<T>>.doOnLoading(action: suspend (T?) -> Unit): Flow<Resource<T>> = transform { result ->
    if (result is Resource.Loading){
        action(result.data)
    }
    return@transform emit(result)

}