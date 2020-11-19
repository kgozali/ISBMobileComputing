package com.isbmobilecomputing.api

import com.google.gson.annotations.SerializedName

open class BaseResponse<T> {
    @SerializedName("message")
    var message: String? = null
    @SerializedName("data")
    var data: T? = null
    @SerializedName("code")
    var statusCode: Int = 0
    @SerializedName("success")
    var status: Boolean = false
}