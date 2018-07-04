package com.udesh.fishtank.data

import com.udesh.fishtank.data.remote.RemoteDataSource
import com.udesh.fishtank.data.remote.Response
import io.reactivex.Single

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getFeeds(): Single<Response> {
        return remoteDataSource.getFeeds()
    }

}