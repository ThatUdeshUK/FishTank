package com.udesh.fishtank.data.remote

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    private val readKey = "T6V9DOA4CSBOLLOC"
    private val writeKey = "RMTH1EMF8QAY57MT"
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

    private fun createRetrofit(baseUrl: String, key: String): Retrofit {
        val builder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        return builder.client(createOkHttpClient(key))
                .build()
    }

    private fun getApiService(isRead: Boolean): ApiService {
        val key = if (isRead) readKey else writeKey
        val retrofit = createRetrofit(baseUrl, key)
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    fun getFeeds(entryCount: Int? = null): Single<Response> {
        return getApiService(true).feeds(entryCount)
    }

}