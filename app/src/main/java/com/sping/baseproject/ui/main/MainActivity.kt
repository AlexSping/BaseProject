package com.sping.baseproject.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sping.baseproject.R
import com.sping.baseproject.base.BaseActivity
import com.sping.baseproject.databinding.MainActivityBinding
import com.sping.baseproject.utils.extentions.setFullScreen
import com.sping.baseproject.utils.viewmodel.InjectingViewModelFactory
import javax.inject.Inject

class MainActivity @Inject constructor() : BaseActivity<MainActivityBinding>() {

    @Inject
    lateinit var injectingViewModelFactory: InjectingViewModelFactory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        viewModel = ViewModelProvider(this, injectingViewModelFactory).get(MainViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.main_activity
    }
}