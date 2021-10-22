package com.test.data.repository

import com.test.data.source.RemoteDataSource
import com.test.domain.CharacterResult

class MarvelRepository(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun suspenCharacters(page: Int): List<CharacterResult> {
        return remoteDataSource.getCaharcters(page)
    }

    suspend fun suspendDetails(id: Int): CharacterResult {
        return remoteDataSource.getDetails(id)
    }

}