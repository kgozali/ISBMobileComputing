package com.isbmobilecomputing.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TransporterService {
    @GET("shipmentSummary")
    fun getShipmentSummary(
        @Query("month") month: Int,
        @Query("year") year: Int
    ): Call<TransporterResponse>
}