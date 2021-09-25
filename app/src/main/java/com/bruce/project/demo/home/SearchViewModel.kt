package com.bruce.project.demo.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bruce.project.demo.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
) : ViewModel() {

    fun getSearchDataList(userName: String) =
        userDataRepository.getSearchDataListPage(userName).cachedIn(viewModelScope)
}