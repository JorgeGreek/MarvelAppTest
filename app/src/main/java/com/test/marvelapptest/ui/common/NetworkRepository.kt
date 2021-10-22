package com.test.marvelapptest.ui.common

import com.test.marvelapptest.network.NetworkDataSource


class NetworkRepository(
    private val networkDataSource: NetworkDataSource
) {
    suspend fun manageNetworkManager(lifecycle: Any, listener: (Boolean) -> Unit) =
        networkDataSource.manageNetworkManager(lifecycle, listener)
}
