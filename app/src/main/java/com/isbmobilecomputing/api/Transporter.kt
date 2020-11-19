package com.isbmobilecomputing.api

import com.google.gson.annotations.SerializedName

class Transporter {
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("name")
    var name: String? = null
}