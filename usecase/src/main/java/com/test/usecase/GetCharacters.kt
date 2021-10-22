package com.test.usecase

import com.test.data.repository.MarvelRepository
import com.test.domain.CharacterResult

class GetCharacters (private val marvelRepository: MarvelRepository) {
    suspend fun invoke(page: Int): List<CharacterResult> = marvelRepository.suspenCharacters(page)
}