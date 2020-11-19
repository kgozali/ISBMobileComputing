package com.isbmobilecomputing.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface OtherService {
    @GET("shipmentSummary")
    fun getOtherService(
        @Query("month") month: Int,
        @Query("year") year: Int
    ): Call<BaseResponse<List<ShipmentSummary>>>
}