package com.sping.baseproject.di.module

import androidx.appcompat.app.AppCompatActivity
import com.sping.baseproject.di.extra.ActivityScope
import com.sping.baseproject.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [Module] that satisfies [AppCompatActivity] dependencies
 */
@Module
abstract class ActivityModule {

    /**
     * Provides [MainActivity] dependency
     */
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}