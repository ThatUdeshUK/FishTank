package com.udesh.fishtank.data.remote

import com.udesh.fishtank.extensions.mainThreadSafely
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    private val readKey = "T6V9DOA4CSBOLLOC"
    private val writeKey = "5K6YA84D9GQZV9JJ"
    private val baseUrl: String = "https://api.thingspeak.com/"

    private fun createOkHttpClient(key: String): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()
            val urlBuilder = originalHttpUrl.newBuilder()
            urlBuilder.addQueryParameter("api_key", key)
            val url = urlBuilder.build()
            // Request customization: add request headers
            val requestBuilder = original.newBuilder().url(url)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

    private fun createRetrofit(baseUrl: String, isRead: Boolean): Retrofit {
        val key = if (isRead) readKey else writeKey
        val builder = Retrofit.Builder()
                .baseUrl(baseUrl)
//        if (isRead) {
        builder.addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        }
        return builder.client(createOkHttpClient(key))
                .build()
    }

    private fun getApiService(isRead: Boolean): ApiService {
        val retrofit = createRetrofit(baseUrl, isRead)
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    fun getFeeds(entryCount: Int? = null): Call<Response> {
        return getApiService(true).feeds(entryCount)
    }

    fun setOperation(operation: Int): Single<Boolean> {
        return Single.fromCallable {
            getApiService(false).write(operation).execute()
            true
        }.mainThreadSafely()
    }
}