package com.sping.baseproject.di.component

import android.app.Application
import com.sping.baseproject.App
import com.sping.baseproject.di.extra.AppScope
import com.sping.baseproject.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Root [Component] that holds all dependencies
 */
@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DatabaseModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ActivityModule::class,
        NavHostModule::class,
        FragmentFactoryModule::class,
        FragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}