package com.yuryi.aura.test.domain

import com.yuryi.aura.test.domain.model.BootEvent
import kotlinx.coroutines.flow.Flow

interface BootEventRepository {
    val bootEvents: Flow<List<BootEvent>>

    suspend fun addBootEvent(bootEvent: BootEvent)
}
