package com.adegoke.cowrywisecodingtest

import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Call
import java.util.*

class Repository(var apiInterface: ApiInterface) {


    fun executeCall(): Call<RatesResponse>{
        return apiInterface.getRatesAsync("EUR")
    }
}