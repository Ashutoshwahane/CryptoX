package xyz.cybernerd404.cryptox.network

import okhttp3.ResponseBody


/**
 * To handle api success and failure or network issue
 * Resource class is going to generic because it will handle all kind of api response <out T>
 * */

sealed class Resource<out T> {

    data class Success<out T>(val value: T): Resource<T>()

    data class Failure(
        val isNetworkErro: Boolean?,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ): Resource<Nothing>()

}