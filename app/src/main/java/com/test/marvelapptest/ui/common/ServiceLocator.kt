package com.test.marvelapptest.ui.common

import android.content.Context
import com.test.marvelapptest.network.NetworkDataSourceImpl

object ServiceLocator {

    fun provideNetworkRepository(
        context: Context
    ): NetworkRepository =
        NetworkRepository(
            NetworkDataSourceImpl(
                context
            )
        )
}
