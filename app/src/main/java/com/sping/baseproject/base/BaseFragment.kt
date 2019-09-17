package com.sping.baseproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

/**
 * Base class that every Activity in the project should extend
 *
 * - Makes [BaseFragment] injectable
 * - Handles [ViewDataBinding]
 */
abstract class BaseFragment<T : ViewDataBinding>  : DaggerFragment() {

    lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Creation of layout data binding
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    /**
     * @return The layout id that's gonna be the fragment's inflated view.
     */
    protected abstract fun getLayoutId(): Int

}
