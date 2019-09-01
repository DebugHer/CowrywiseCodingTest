package com.adegoke.cowrywisecodingtest.di.component

import com.adegoke.cowrywisecodingtest.MainActivity
import com.adegoke.cowrywisecodingtest.di.module.AppModule
import com.adegoke.cowrywisecodingtest.di.module.UtilsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (UtilsModule::class)])
interface MyAppComponent{
    fun inject(view: MainActivity)
}