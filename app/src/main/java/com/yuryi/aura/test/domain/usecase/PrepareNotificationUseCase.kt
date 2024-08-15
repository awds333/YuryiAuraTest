package com.yuryi.aura.test.domain.usecase

import com.yuryi.aura.test.domain.BootEventRepository
import com.yuryi.aura.test.domain.NotificationRepository
import com.yuryi.aura.test.domain.usecase.core.UseCase
import com.yuryi.aura.test.presentation.util.format
import kotlinx.coroutines.flow.first
import kotlin.time.Duration

class PrepareNotificationUseCase(
    private val notificationRepository: NotificationRepository,
    private val bootEventRepository: BootEventRepository
) : UseCase {

    suspend operator fun invoke() = runCatching {
        val events = bootEventRepository.bootEvents.first()
            .sortedByDescending { it.datetime }
            .take(2)

        val body = when (events.size) {
            0 -> "No boots detected"
            1 -> "The boot was detected = ${events.first().datetime.format()}"
            else -> {
                val (first, second) = events
                // TODO compute perioud
                "Last boots time delta"
            }
        }

        notificationRepository.createNotification(body)
    }
}
