package com.test.network



class ManageNetworkManager(private val networkRepository: NetworkRepository) {
    suspend fun invoke(lifecycle: Any, listener: (Boolean) -> Unit) =
        networkRepository.manageNetworkManager(lifecycle, listener)
}
