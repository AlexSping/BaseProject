package com.sping.baseproject.ui.about

import android.os.Bundle
import com.sping.baseproject.R
import com.sping.baseproject.base.BaseFragment
import com.sping.baseproject.databinding.FragmentPostBinding
import javax.inject.Inject

class AboutFragment @Inject constructor() : BaseFragment<FragmentPostBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_about
    }

}