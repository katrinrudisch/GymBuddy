package com.katrinrudisch.gymbuddy

import android.app.Application
import com.katrinrudisch.gymbuddy.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GymBuddyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@GymBuddyApplication)
            modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    retrofitModule,
                    apiModule,
                    databaseModule
                )
            )
        }
    }
}