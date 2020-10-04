package com.marleyspoon.techchallenge.di

import android.app.Application
import com.marleyspoon.techchallenge.App
import com.marleyspoon.techchallenge.di.module.ActivityBuilderModule
import com.marleyspoon.techchallenge.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ApplicationModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        @BindsInstance
        abstract fun app(application: Application): Builder
    }
}