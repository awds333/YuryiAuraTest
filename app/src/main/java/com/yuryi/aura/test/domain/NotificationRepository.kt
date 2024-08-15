package com.yuryi.aura.test.domain

import com.yuryi.aura.test.domain.model.Notification
import kotlin.time.Duration

interface NotificationRepository {

    suspend fun notificationAppearancePeriod(): Duration
    suspend fun setNotificationAppearancePeriod(period: Duration)
    suspend fun setNotificationDismissed(notificationId: Int)
    suspend fun createNotification(body: String): Notification
}
