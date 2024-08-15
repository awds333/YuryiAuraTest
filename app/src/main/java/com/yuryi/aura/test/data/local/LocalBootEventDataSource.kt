package com.yuryi.aura.test.data.local

import com.yuryi.aura.test.data.model.BootEventDto
import kotlinx.coroutines.flow.Flow

interface LocalBootEventDataSource {

    val bootEvents: Flow<List<BootEventDto>>
    suspend fun addBootEvent(bootEvent: BootEventDto)
}
