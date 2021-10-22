package com.test.marvelapptest.network

import com.test.marvelapptest.ui.common.NetworkRepository


class ManageNetworkManager(private val networkRepository: NetworkRepository) {
    suspend fun invoke(lifecycle: Any, listener: (Boolean) -> Unit) =
        networkRepository.manageNetworkManager(lifecycle, listener)
}
