package com.sping.baseproject.di.module

import androidx.fragment.app.Fragment
import com.sping.baseproject.di.extra.ActivityScope
import com.sping.baseproject.utils.navigation.InjectingNavHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [Module] that satisfies [InjectingNavHostFragment] dependencies
 */
@Module
abstract class NavHostModule {

    /**
     * Provides [InjectingNavHostFragment] dependency
     */
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun navHostFragmentInjector(): InjectingNavHostFragment

}