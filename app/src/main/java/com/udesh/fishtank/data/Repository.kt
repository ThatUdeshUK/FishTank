package com.udesh.fishtank.data

import com.udesh.fishtank.data.remote.RemoteDataSource
import com.udesh.fishtank.data.remote.Response
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getFeeds(): Call<Response> {
        return remoteDataSource.getFeeds(1)
    }

    fun setOperation(operation: Int): Single<Boolean> {
        return remoteDataSource.setOperation(operation)
    }

    object Operation {
        const val FOOD = 1
        const val WATER = 2
    }

}