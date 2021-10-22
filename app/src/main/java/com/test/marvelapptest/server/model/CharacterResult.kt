package com.test.marvelapptest.server.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterResult(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val thumbnail: Thumbnail,
    val comics: SubData
): Parcelable