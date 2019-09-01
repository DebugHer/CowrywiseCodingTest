package com.adegoke.cowrywisecodingtest

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.realm.Realm

class MainViewModel(val repository: Repository): ViewModel(){

    private var currencyLiveData = MutableLiveData<RatesResponse>()

    fun apiResponse(): LiveData<RatesResponse> {
        Log.d("ErrorRetrofitTrace1", "here")

            currencyLiveData = MutableLiveData()
            Log.d("ErrorRetrofitTrace2", "here")

            makeTheRequest()
            Log.d("ErrorRetrofitTrace3", "here")

        return currencyLiveData
        Log.d("ErrorRetrofitTrace4", "here")
    }

    private fun makeTheRequest() {
        Log.d("ErrorRetrofitTrace5", "here")
        repository.executeCall().enqueue(
            object :retrofit2.Callback<RatesResponse>{
                override fun onFailure(call: retrofit2.Call<RatesResponse>, t: Throwable) {
                    Log.d("ErrorRetrofit", t.message)
                    Log.d("ErrorRetrofitTrace6", "here")
                }

                override fun onResponse(
                    call: retrofit2.Call<RatesResponse>,
                    response: retrofit2.Response<RatesResponse>
                ) {
                    if(response.isSuccessful){

                        Log.d("ErrorRetrofitWhy", response.body().toString())
                        Log.d("ErrorRetrofitWhy", response.raw().toString())
                        currencyLiveData.value = response.body()

                        val ratesModel = RatesModel()

                        var realm = Realm.getDefaultInstance()

                        //save in the db
                        ratesModel.addCurrencies(realm, response.body()?.rates)
                        Log.d("SuccessMess!","Saved in the DB")

                    }else{
                        Log.d("SuccessMess!",response.message())
                    }
                }
            }
        )
    }
}