package com.test.network

import android.content.Context


class NetworkDataSourceImpl(
    private val context: Context
) : NetworkDataSource {

    override suspend fun manageNetworkManager(lifecycle: Any, listener: (Boolean) -> Unit) {
        NetworkManager(
            context,
            lifecycle as Lifecycle
        ).isInternetAvailable.collect {
            listener(it)
        }
    }
}
