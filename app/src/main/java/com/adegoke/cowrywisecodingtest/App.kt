package com.adegoke.cowrywisecodingtest

import android.app.Application
import com.adegoke.cowrywisecodingtest.di.component.DaggerMyAppComponent
import com.adegoke.cowrywisecodingtest.di.component.MyAppComponent
import com.adegoke.cowrywisecodingtest.di.module.AppModule
import com.adegoke.cowrywisecodingtest.di.module.UtilsModule
import io.realm.Realm
import io.realm.RealmConfiguration

class App: Application(){

    private lateinit var appComponent: MyAppComponent

    companion object{
        lateinit var mInstance: App

        fun getInstance(): App{
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        appComponent = DaggerMyAppComponent.builder()
            .appModule(AppModule(this))
            .utilsModule(UtilsModule())
           .build()
        //Initialize realm
        Realm.init(mInstance)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

    }
    fun getAppComponent(): MyAppComponent{
        return appComponent
    }
}