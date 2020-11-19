package com.isbmobilecomputing.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val interceptedRequest: Request = chain.request()

        val request: Request = interceptedRequest.newBuilder()
            .header(KEY_ACCEPT, "application/json")
            .header(KEY_AUTHORIZATION, "37745f67b6272ea21420043c60219ed1868066928d16cdc97e65374514abea257c1daaffe4d9416a3af05a5520837f67e5a01ab287186249bef5cbea907137c8")
            .method(interceptedRequest.method, interceptedRequest.body)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val KEY_ACCEPT = "Accept"
        private const val KEY_AUTHORIZATION = "token"
    }
}