package com.test.marvelapptest.ui.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.test.domain.CharacterResult
import com.test.marvelapptest.ui.common.ScopedViewModel
import com.test.marvelapptest.ui.paging.ResultPagingSource
import com.test.usecase.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject constructor(
    private val getCharacters: GetCharacters
) : ScopedViewModel() {


    fun apiData(): Flow<PagingData<CharacterResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = 18,
                enablePlaceholders = false//,
                //     maxSize = 30,
                //     prefetchDistance = 5,
                //     initialLoadSize = 10
            ),
            pagingSourceFactory = { ResultPagingSource(getCharacters) }
        ).flow
    }

}