package com.test.marvelapptest.network

import android.content.Context
import androidx.lifecycle.Lifecycle
import com.test.marvelapptest.ui.common.NetworkManager
import kotlinx.coroutines.flow.collect

class NetworkDataSourceImpl(
    private val context: Context
) : NetworkDataSource {

    override suspend fun manageNetworkManager(lifecycle: Any, listener: (Boolean) -> Unit) {
        NetworkManager(
            context,
            lifecycle as Lifecycle
        ).isInternetAvailable.collect() {
            listener(it)
        }
    }
}
