package com.sample.mvvmarchiteturetest.util


sealed class NetworkResult<T>() {

    data class Success<T>(var data: T) : NetworkResult<T>()

    data class Error<T>(var message: String?, var data: T? = null) : NetworkResult<T>()

     class Loading<T>() : NetworkResult<T>()
}
