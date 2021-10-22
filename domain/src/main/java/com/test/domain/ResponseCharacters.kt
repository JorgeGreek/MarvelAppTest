package com.test.domain

data class ResponseCharacters(
    val code: Int,
    val status: String,
    val `data`: Data
)