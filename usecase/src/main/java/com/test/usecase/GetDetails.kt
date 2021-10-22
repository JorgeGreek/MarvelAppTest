package com.test.usecase

import com.test.data.repository.MarvelRepository
import com.test.domain.CharacterResult

class GetDetails(private val marvelRepository: MarvelRepository) {
    suspend fun invoke(id: Int): CharacterResult = marvelRepository.suspendDetails(id)
}