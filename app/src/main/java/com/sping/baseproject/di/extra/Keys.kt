package com.sping.baseproject.di.extra

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.sping.baseproject.utils.navigation.InjectingFragmentFactory
import com.sping.baseproject.utils.viewmodel.InjectingViewModelFactory
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * ViewModelKeys helps map [Fragment] classes so [InjectingFragmentFactory] can correctly provide/inject them.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(value = AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)

/**
 * ViewModelKeys helps map [ViewModel] classes so [InjectingViewModelFactory] can correctly provide/inject them.
 */
@Target(AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value:  KClass<out ViewModel>)