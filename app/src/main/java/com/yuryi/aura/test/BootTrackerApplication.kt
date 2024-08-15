package com.yuryi.aura.test

import android.app.Application
import com.yuryi.aura.test.di.appModules
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class BootTrackerApplication : Application() {

    private val applicationScope: CoroutineScope = CoroutineScope(SupervisorJob())

    private val scopeModule = module {
        factory<CoroutineScope> { applicationScope }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BootTrackerApplication)
            modules(*appModules, scopeModule)
        }


    }

    override fun onTerminate() {
        applicationScope.cancel("Application terminated")
        super.onTerminate()
    }
}
