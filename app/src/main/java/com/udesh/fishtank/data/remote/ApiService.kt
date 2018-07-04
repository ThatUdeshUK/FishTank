package com.udesh.fishtank.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("channels/419472/feeds.json")
    fun feeds(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/1.json")
    fun field1(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/2.json")
    fun field2(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/3.json")
    fun field3(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/4.json")
    fun field4(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/5.json")
    fun field5(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/6.json")
    fun field6(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/7.json")
    fun field7(@Query("results") results: Int? = null): Single<Response>

    @GET("channels/419472/fields/8.json")
    fun field8(@Query("results") results: Int? = null): Single<Response>

}

//https://api.thingspeak.com/channels/419472/feeds.json?&results=1