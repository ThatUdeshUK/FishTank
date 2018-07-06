package com.udesh.fishtank.data

import com.udesh.fishtank.data.remote.RemoteDataSource
import com.udesh.fishtank.data.remote.Response
import io.reactivex.Single

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getFeeds(): Single<Response> {
        return remoteDataSource.getFeeds()
    }

    fun setOperation(operation: Int): Single<Boolean> {
        return remoteDataSource.setOperation(operation)
    }

    object Operation {
        val NON = 0
        val FOOD = 1
        val WATER = 2
    }

}