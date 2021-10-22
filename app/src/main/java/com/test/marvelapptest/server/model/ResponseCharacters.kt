package com.test.marvelapptest.server.model


data class ResponseCharacters(
    val code: Int,
    val status: String,
    val `data`: Data
)