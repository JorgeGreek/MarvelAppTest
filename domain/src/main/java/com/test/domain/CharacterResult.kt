package com.test.domain

data class CharacterResult(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val thumbnail: Thumbnail,
    val comics: SubData
)