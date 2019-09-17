package com.sping.baseproject.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sping.baseproject.ui.main.MainViewModel
import com.sping.baseproject.ui.post.PostFragmentViewModel
import com.sping.baseproject.utils.viewmodel.InjectingViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.sping.baseproject.di.extra.ViewModelKey

/**
 * [Module] that satisfies [InjectingViewModelFactory] dependencies
 */
@Module
abstract class ViewModelFactoryModule {

    /**
     * Binds [InjectingViewModelFactory] dependency
     */
    @Binds
    abstract fun bindViewModelFactory(injectingViewModelFactory: InjectingViewModelFactory): ViewModelProvider.Factory

    /**
     * Binds [MainViewModel] dependency
     */
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    /**
     * Binds [PostFragmentViewModel] dependency
     */
    @Binds
    @IntoMap
    @ViewModelKey(PostFragmentViewModel::class)
    protected abstract fun bindPostModel(postFragmentViewModel: PostFragmentViewModel): ViewModel

}