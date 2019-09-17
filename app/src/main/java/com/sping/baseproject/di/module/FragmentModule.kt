package com.sping.baseproject.di.module

import androidx.fragment.app.Fragment
import com.sping.baseproject.di.extra.ActivityScope
import com.sping.baseproject.ui.post.PostFragment
import com.sping.baseproject.utils.navigation.InjectingFragmentFactory
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [Module] that satisfies [Fragment]s dependencies
 */
@Module
abstract class FragmentModule{

    /**
     * Provides [PostFragment] dependency
     */
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment

}