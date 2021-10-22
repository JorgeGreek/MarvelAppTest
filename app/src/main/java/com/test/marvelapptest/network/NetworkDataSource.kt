package com.test.marvelapptest.network

interface NetworkDataSource {
    suspend fun manageNetworkManager(lifecycle: Any, listener: (Boolean) -> Unit)
}
