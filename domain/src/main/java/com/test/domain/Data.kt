package com.test.domain

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<CharacterResult>,
    val total: Int
)