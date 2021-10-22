package com.test.marvelapptest.server.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemData(
    val name: String,
    val resourceURI: String,
    val type: String?
): Parcelable