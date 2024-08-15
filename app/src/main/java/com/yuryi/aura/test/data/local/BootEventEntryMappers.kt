package com.yuryi.aura.test.data.local

import com.yuryi.aura.test.data.local.database.BootEventEntry
import com.yuryi.aura.test.data.model.BootEventDto
import kotlinx.datetime.Instant

fun BootEventEntry.toDto(): BootEventDto = BootEventDto(
    Instant.fromEpochMilliseconds(instant)
)

fun BootEventDto.toEntry(): BootEventEntry = BootEventEntry(
    instant.toEpochMilliseconds()
)
