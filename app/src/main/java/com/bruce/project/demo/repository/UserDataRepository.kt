package com.bruce.project.demo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.bruce.project.demo.api.GitApi
import com.bruce.project.demo.data.SearchDataSource
import dagger.Reusable
import javax.inject.Inject

@Reusable
class UserDataRepository @Inject constructor(
    private val gitApi: GitApi,
) {

    fun getSearchDataListPage(userName: String) =
        Pager(PagingConfig(pageSize = 10)) {
            SearchDataSource(userName, gitApi)
        }.flow
}