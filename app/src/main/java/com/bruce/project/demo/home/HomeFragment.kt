package com.bruce.project.demo.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bruce.project.demo.R
import com.bruce.project.demo.databinding.HomeFragmentBinding
import com.bruce.project.demo.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {
    private val viewModel by viewModels<SearchViewModel>()
    private val binding by viewBinding(HomeFragmentBinding::bind)
    private val searchAdapter = SearchAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btSearch.setOnClickListener {
           val searchName = binding.edSearch.text.toString()

            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.getSearchDataList(searchName).collectLatest {
                    searchAdapter.submitData(it)
                }
            }
        }

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }
    }
}