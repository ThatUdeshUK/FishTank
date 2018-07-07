package com.udesh.fishtank.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("channels/419472/feeds.json")
    fun feeds(@Query("results") results: Int? = null): Call<Response>

//    @GET("channels/419472/fields/1.json")
//    fun waterLevel(@Query("results") results: Int? = null): Single<Response>
//
//    @GET("channels/419472/fields/2.json")
//    fun pressure(@Query("results") results: Int? = null): Single<Response>
//
//    @GET("channels/419472/fields/3.json")
//    fun ph(@Query("results") results: Int? = null): Single<Response>
//
//    @GET("channels/419472/fields/4.json")
//    fun o2(@Query("results") results: Int? = null): Single<Response>
//
//    @GET("channels/419472/fields/5.json")
//    fun temperature(@Query("results") results: Int? = null): Single<Response>
//
//    @GET("channels/419472/fields/6.json")
//    fun foodLeft(@Query("results") results: Int? = null): Single<Response>

    @GET("update")
    fun write(@Query("field1") results: Int = 0): Call<Void>


//    @GET("channels/419472/fields/7.json")
//    fun field7(@Query("results") results: Int? = null): Single<Response>
//
//    @GET("channels/419472/fields/8.json")
//    fun field8(@Query("results") results: Int? = null): Single<Response>

}
