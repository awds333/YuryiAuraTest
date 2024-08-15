package com.yuryi.aura.test.domain.usecase

import com.yuryi.aura.test.domain.BootEventRepository
import com.yuryi.aura.test.domain.model.BootEvent
import com.yuryi.aura.test.domain.usecase.core.UseCase
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class RegisterBootEventUseCase(private val repository: BootEventRepository) : UseCase {

    suspend operator fun invoke(): Result<Unit> = runCatching {
        val bootEvent = BootEvent(
            datetime = Clock.System.now()
                .toLocalDateTime(timeZone = TimeZone.currentSystemDefault())
        )
        repository.addBootEvent(bootEvent)
    }
}
