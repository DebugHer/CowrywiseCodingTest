package com.adegoke.cowrywisecodingtest.di.module

import com.adegoke.cowrywisecodingtest.ApiInterface
import com.adegoke.cowrywisecodingtest.CurrencyViewModelFactory
import com.adegoke.cowrywisecodingtest.Repository
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class UtilsModule {


    @Provides
    @Singleton
    fun provideGson(): Gson {
        var builder: GsonBuilder = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.setLenient().create()
     //   return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder().client(okHttpClient)
            .baseUrl("http://data.fixer.io/api/")

            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)

                .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun getApiCallInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun getRequestHeader(): OkHttpClient {
        val API_KEY = "11c8670d778a6948e32db2b273144add"

        //Network interceptor to add apiKey in all the requests as authInterceptor
        val interceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder()
                .addQueryParameter("access_key", API_KEY).build()
            val request = chain.request().newBuilder().url(url).build()
            chain.proceed(request)


        }
        val apiClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
        return apiClient
    }

    @Provides
    @Singleton
    fun getViewModelFactory(mRepository: Repository): CurrencyViewModelFactory {
        return CurrencyViewModelFactory(mRepository)
    }

    @Provides
    @Singleton
    fun getRepository(mApiCallInterface: ApiInterface): Repository {
        return Repository(mApiCallInterface)
    }


}