package com.test.domain

data class SubData(
    val available: String,
    val collectionURI: String,
    val items: List<ItemData>,
    val returned: String
)