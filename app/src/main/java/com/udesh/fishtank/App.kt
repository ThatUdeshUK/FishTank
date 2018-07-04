package com.udesh.fishtank

import androidx.multidex.MultiDexApplication
import com.udesh.fishtank.di.appModule
import org.koin.android.ext.android.startKoin

class App: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(appModule)
    }
}