package com.yuryi.aura.test.domain.usecase

import com.yuryi.aura.test.domain.BootEventRepository
import com.yuryi.aura.test.domain.model.BootEventsForDate
import com.yuryi.aura.test.domain.usecase.core.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BootEventsForDatesUseCase(private val repository: BootEventRepository) : UseCase {

    operator fun invoke(): Result<Flow<List<BootEventsForDate>>> = runCatching {
        repository.bootEvents
            .map { bootEvents ->
                bootEvents.groupBy { event -> event.datetime.date }
                    .map { (date, bootEvents) ->
                        val sortedBootEvents = bootEvents.sortedByDescending { it.datetime }
                        BootEventsForDate(date, sortedBootEvents)
                    }
                    .sortedByDescending { it.date }
            }
    }
}
