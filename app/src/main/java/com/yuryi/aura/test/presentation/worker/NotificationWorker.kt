package com.yuryi.aura.test.presentation.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.yuryi.aura.test.presentation.util.NotificationSender
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NotificationWorker(context: Context, params: WorkerParameters) : Worker(context, params),
    KoinComponent {

    private val notificationSender: NotificationSender by inject()

    override fun doWork(): Result {

        // Create Notification
        // Show Notification

        return Result.success()
    }
}
