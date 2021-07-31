package xyz.cybernerd404.cryptox.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import xyz.cybernerd404.cryptox.network.Resource
import xyz.cybernerd404.cryptox.utils.debug

abstract class BaseRepository {
    suspend fun  <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T>{
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable){
                when (throwable){
                    is HttpException -> {
                        Resource.Failure(false,throwable.code(), throwable.response()?.errorBody())
                    }
                    else ->{
                        Resource.Failure(true, null, null)
                    }
                }
            }
        }
    }
}