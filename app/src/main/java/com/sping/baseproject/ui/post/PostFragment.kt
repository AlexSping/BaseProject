package com.sping.baseproject.ui.post

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sping.baseproject.R
import com.sping.baseproject.base.BaseFragment
import com.sping.baseproject.databinding.FragmentPostBinding
import com.sping.baseproject.utils.viewmodel.InjectingViewModelFactory
import javax.inject.Inject

class PostFragment @Inject constructor() : BaseFragment<FragmentPostBinding>() {

    @Inject
    lateinit var injectingViewModelFactory: InjectingViewModelFactory

    private lateinit var viewModel: PostFragmentViewModel

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this, injectingViewModelFactory).get(PostFragmentViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.viewModel = viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_post
    }

}