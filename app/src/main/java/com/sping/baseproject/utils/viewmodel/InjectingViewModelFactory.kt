package com.sping.baseproject.utils.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Extended class of [ViewModelProvider.Factory] to make it compatible with Dagger2
 */
@Suppress("UNCHECKED_CAST")
class InjectingViewModelFactory
@Inject constructor(private val creators: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return creators[modelClass]?.get() as? T ?: throw IllegalArgumentException("The requested ViewModel isn't bound")
    }

}