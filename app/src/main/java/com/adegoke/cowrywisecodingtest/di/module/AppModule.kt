package com.adegoke.cowrywisecodingtest.di.module

import android.content.Context
import com.adegoke.cowrywisecodingtest.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }


}