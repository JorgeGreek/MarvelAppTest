package com.test.marvelapptest.server

import com.test.data.source.RemoteDataSource
import com.test.domain.CharacterResult
import com.test.marvelapptest.ui.common.md5
import javax.inject.Inject

class TheMarvelDataSource @Inject constructor(private val api: ApiService, private val marvelCredentialDataSource: MarvelCredentialDataSource) : RemoteDataSource {



    override suspend fun getCaharcters(page: Int): List<CharacterResult> {
        val ts = marvelCredentialDataSource.timeStamp
        val publicKey = marvelCredentialDataSource.publicKey
        val hash = marvelCredentialDataSource.hash
        val characters = api.listCharacters(ts, publicKey, hash, page).data.results.map { it.toDomainCharacter() }
        return characters
    }

    override suspend fun getDetails(id: Int): CharacterResult {
        val ts = marvelCredentialDataSource.timeStamp
        val publicKey = marvelCredentialDataSource.publicKey
        val hash = marvelCredentialDataSource.hash
        val characterRemote = api.getCharacterDetailsRemote(id, ts, publicKey, hash).data.results[0].toDomainCharacter()
        return characterRemote
    }

}