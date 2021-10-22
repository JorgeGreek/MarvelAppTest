package com.test.data.source

import com.test.domain.CharacterResult

interface RemoteDataSource {
    suspend fun getCaharcters(page: Int): List<CharacterResult>
    suspend fun getDetails(id: Int): CharacterResult
}