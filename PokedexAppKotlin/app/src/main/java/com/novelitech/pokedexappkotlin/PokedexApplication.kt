package com.novelitech.pokedexappkotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PokedexApplication : Application() {

    // To use Timber to log things, I need to set it up on onCreate
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}