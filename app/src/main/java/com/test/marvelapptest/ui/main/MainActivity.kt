package com.test.marvelapptest.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.test.marvelapptest.R
import com.test.marvelapptest.ui.common.startActivity
import com.test.marvelapptest.ui.home.HomeActivity

class MainActivity : AppCompatActivity() {

    private var TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadSplashScreen()
    }

    private fun loadSplashScreen() {
        Handler().postDelayed({
            startActivity<HomeActivity>()
        }, TIME_OUT)
    }

}