package com.test.marvelapptest.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.test.domain.CharacterResult
import com.test.marvelapptest.server.DEFAULT_PAGE_INDEX
import com.test.marvelapptest.server.VALUE_COUNT_PAGE
import com.test.usecase.GetCharacters
import retrofit2.HttpException
import java.io.IOException

class ResultPagingSource(
    val getCharacters: GetCharacters
) : PagingSource<Int, CharacterResult>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, CharacterResult> {
        return try {
            val offset = params.key ?:  DEFAULT_PAGE_INDEX - 1
            val response = getCharacters.invoke(offset)
            val results = response
            LoadResult.Page(
                data = results,
                prevKey = null,
                nextKey = if (results!!.isEmpty()) null else offset + VALUE_COUNT_PAGE
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(DEFAULT_PAGE_INDEX) ?: anchorPage?.nextKey?.minus(DEFAULT_PAGE_INDEX)
        }
    }

}
