package com.test.network

interface NetworkDataSource {
    suspend fun manageNetworkManager(lifecycle: Any, listener: (Boolean) -> Unit)
}
