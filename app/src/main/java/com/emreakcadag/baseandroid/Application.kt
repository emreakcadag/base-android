package com.emreakcadag.baseandroid

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Emre Akçadağ on 26.02.2022
 */
@HiltAndroidApp
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}