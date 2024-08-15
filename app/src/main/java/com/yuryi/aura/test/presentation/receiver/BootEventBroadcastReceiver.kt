package com.yuryi.aura.test.presentation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.yuryi.aura.test.domain.usecase.RegisterBootEventUseCase
import com.yuryi.aura.test.domain.usecase.core.UseCaseFactory
import com.yuryi.aura.test.domain.usecase.core.delegate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BootEventBroadcastReceiver : BroadcastReceiver(), KoinComponent {

    private val applicationScope: CoroutineScope by inject()
    private val registerBootEventUseCaseFactory: UseCaseFactory<RegisterBootEventUseCase> by inject()

    private val registerBootEventUseCase by registerBootEventUseCaseFactory.delegate()

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action != Intent.ACTION_BOOT_COMPLETED) {
            println("Unexpected intent: ${intent?.action}")
        }

        applicationScope.launch {
            registerBootEventUseCase()
        }
    }
}
