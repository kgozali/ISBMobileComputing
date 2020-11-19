package com.isbmobilecomputing.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://webservice.truckr.id/index.php/api/Mobile/"

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(NetworkInterceptor())
        .retryOnConnectionFailure(true)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitBuilder(): Retrofit {
        return retrofit
    }
}