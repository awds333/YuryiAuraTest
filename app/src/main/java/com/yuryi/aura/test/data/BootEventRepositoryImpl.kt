package com.yuryi.aura.test.data

import com.yuryi.aura.test.data.local.LocalBootEventDataSource
import com.yuryi.aura.test.data.mapper.toDomain
import com.yuryi.aura.test.data.mapper.toDto
import com.yuryi.aura.test.data.model.BootEventDto
import com.yuryi.aura.test.domain.BootEventRepository
import com.yuryi.aura.test.domain.model.BootEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn

class BootEventRepositoryImpl(
    scope: CoroutineScope,
    private val localBootEventDataSource: LocalBootEventDataSource,
) : BootEventRepository {

    override val bootEvents: Flow<List<BootEvent>> = localBootEventDataSource.bootEvents
        .map { dtos ->
            dtos.map(BootEventDto::toDomain)
        }.shareIn(scope = scope, replay = 1, started = SharingStarted.WhileSubscribed())

    override suspend fun addBootEvent(bootEvent: BootEvent) {
        localBootEventDataSource.addBootEvent(bootEvent.toDto())
    }
}
