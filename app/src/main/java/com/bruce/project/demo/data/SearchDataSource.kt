package com.bruce.project.demo.data

import androidx.paging.PagingSource
import com.bruce.project.demo.api.GitApi
import com.bruce.project.demo.entity.UserItems
import dagger.Reusable
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@Reusable
class SearchDataSource @Inject constructor(
    private val userName: String,
    private val gitApi: GitApi
) : PagingSource<Int, UserItems>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserItems> {
        return try {
            val page = params.key ?: 1
            val result = gitApi.getUserInfo(
                user = userName,
                query = "user",
                perPage = params.loadSize,
                page = page
            )

            LoadResult.Page(
                prevKey = null,
                nextKey = if (result.totalCount <= params.loadSize) null else page + 1,
                data = result.users
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}