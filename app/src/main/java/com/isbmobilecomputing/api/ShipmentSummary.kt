package com.isbmobilecomputing.api

import com.google.gson.annotations.SerializedName

class ShipmentSummary {
    @SerializedName("transaction_status")
    var transactionStatus: String = ""
    @SerializedName("total_transaction")
    var total: Long = 0
}