package com.adegoke.cowrywisecodingtest

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

data class RatesResponse(
    @SerializedName("base")
    var base: String = "",
    @SerializedName("date")
    var date: String = "",
    @SerializedName("rates")
    var rates: Rates? = null,
    @SerializedName("success")
    var success: Boolean = false,
    @SerializedName("timestamp")
    var timestamp: Int = -1
)

