package com.test.marvelapptest.server

import com.test.marvelapptest.server.model.ResponseCharacters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/public/characters")
    suspend fun listCharacters(
        @Query("ts") ts: Long,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("orderBy") orderBy: String = "name",
        @Query("limit") limit: Int = REQUEST_LIMIT
    ): ResponseCharacters

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacterDetailsRemote(
        @Path("characterId") characterId: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): ResponseCharacters

}