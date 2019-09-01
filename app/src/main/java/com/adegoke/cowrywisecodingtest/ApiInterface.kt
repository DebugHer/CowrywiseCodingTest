package com.adegoke.cowrywisecodingtest

import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //The fixer.io free api plan only allows for EUR as the base. so basically i will be passing EUR as the base.
    //I'm using the coroutines Deferred type
    @GET("latest")
    fun getRatesAsync(@Query("base") base : String) : Call<RatesResponse>
}
