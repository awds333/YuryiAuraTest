package com.yuryi.aura.test.data.local

import com.yuryi.aura.test.data.local.database.BootEventDao
import com.yuryi.aura.test.data.local.database.BootEventEntry
import com.yuryi.aura.test.data.model.BootEventDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalBootEventDataSource(private val dao: BootEventDao) : LocalBootEventDataSource {

    override val bootEvents: Flow<List<BootEventDto>>
        get() = dao.allBootEvents().map { entries ->
            entries.map(BootEventEntry::toDto)
        }

    override suspend fun addBootEvent(bootEvent: BootEventDto) {
        dao.insert(bootEvent.toEntry())
    }
}
