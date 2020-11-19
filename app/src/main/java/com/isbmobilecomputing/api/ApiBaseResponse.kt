package com.isbmobilecomputing.api

import com.google.gson.annotations.SerializedName

open class ApiBaseResponse {
    @SerializedName("message")
    var message: String? = null
    @SerializedName("code")
    var statusCode: Int = 0
    @SerializedName("success")
    var status: Boolean = false
}