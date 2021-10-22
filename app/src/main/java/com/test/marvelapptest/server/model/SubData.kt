package com.test.marvelapptest.server.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubData(
    val available: String,
    val collectionURI: String,
    val items: List<ItemData>,
    val returned: String
): Parcelable