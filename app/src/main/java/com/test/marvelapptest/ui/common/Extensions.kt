package com.test.marvelapptest.ui.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import com.test.marvelapptest.R
import java.math.BigInteger
import java.security.MessageDigest


val String.md5: String
    get() {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(this.toByteArray())).toString(16).padStart(32, '0')
    }


// startActivity<HomeActivity>(DetailActivity.EXTRA_ID to id)
inline fun <reified T : Activity> Context.startActivity(vararg pairs: Pair<String, Any?>) {

    val intent = Intent(this, T::class.java)
        .apply {
            putExtras(bundleOf(*pairs))
        }
    startActivity(intent)
}


// check internet for clicks connection

fun Context.isOnline(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager != null) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
    }
    return false
}


// transform gridView number columns
fun Context.calculateColumsForGridLayout(columnWidthInDP: Float): Int {
    return ((resources.displayMetrics.widthPixels / resources.displayMetrics.density) / columnWidthInDP).toInt()
}


// add ViewModel
@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {

    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return ViewModelProvider(this, vmFactory).get()
}


// load image with Glide
fun ImageView.loadImage(url: String, extension: String?) {
    Glide.with(this)
        .asBitmap()
        .load("$url.$extension")
        .centerCrop()
        .error(R.drawable.marvel_error)
        .into(this)
}

