package com.sping.baseproject.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity

/**
 * Base class that every Activity in the project should extend
 *
 * - Makes [BaseActivity] injectable
 * - Handles [ViewDataBinding]
 */
abstract class BaseActivity<T : ViewDataBinding> : DaggerAppCompatActivity() {

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Creation of layout data binding
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
    }

    /**
     * @return The layout id that's gonna be the activity's inflated view.
     */
    protected abstract fun getLayoutId(): Int

}