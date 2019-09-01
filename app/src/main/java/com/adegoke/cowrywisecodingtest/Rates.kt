package com.adegoke.cowrywisecodingtest

import com.google.gson.annotations.SerializedName

 data class Rates(
    @SerializedName("AED")
    val aED: Double = 0.0,
    @SerializedName("AFN")
    val aFN: Double = 0.0,
    @SerializedName("ALL")
    val aLL: Double = 0.0,
    @SerializedName("AMD")
    val aMD: Double = 0.0,
    @SerializedName("ANG")
    val aNG: Double = 0.0,
    @SerializedName("AOA")
    val aOA: Double = 0.0,
    @SerializedName("ARS")
    val aRS: Double = 0.0,
    @SerializedName("AUD")
    val aUD: Double = 0.0,
    @SerializedName("AWG")
    val aWG: Double = 0.0,
    @SerializedName("AZN")
    val aZN: Double = 0.0,
    @SerializedName("BAM")
    val bAM: Double = 0.0,
    @SerializedName("BBD")
    val bBD: Double = 0.0
 )