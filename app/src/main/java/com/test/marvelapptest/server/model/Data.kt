package com.test.marvelapptest.server.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<CharacterResult>,
    val total: Int
): Parcelable