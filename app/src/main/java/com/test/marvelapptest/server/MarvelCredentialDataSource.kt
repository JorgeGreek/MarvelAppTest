package com.test.marvelapptest.server

import com.test.data.source.CredentialsDataSource
import com.test.marvelapptest.BuildConfig
import com.test.marvelapptest.ui.common.md5
import javax.inject.Inject

class MarvelCredentialDataSource @Inject constructor() : CredentialsDataSource {
    override val timeStamp: Long
        get() = System.currentTimeMillis()
    override val publicKey: String
        get() = BuildConfig.MARVEL_API_KEY
    override val privateKey: String
        get() = BuildConfig.MARVEL_PRIVATE_KEY
    override val hash: String
        get() = "$timeStamp$privateKey$publicKey".md5
}
