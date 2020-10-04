package com.marleyspoon.techchallenge.di.module

import android.content.Context
import com.marleyspoon.techchallenge.App
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class ApplicationModule {

    @Provides
    fun provideContext(application: App): Context = application.applicationContext
}