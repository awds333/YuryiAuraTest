package com.yuryi.aura.test.data.mapper

import com.yuryi.aura.test.data.model.BootEventDto
import com.yuryi.aura.test.domain.model.BootEvent
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun BootEvent.toDto(): BootEventDto = BootEventDto(
    datetime.toInstant(TimeZone.currentSystemDefault())
)

fun BootEventDto.toDomain(): BootEvent = BootEvent(
    instant.toLocalDateTime(TimeZone.currentSystemDefault())
)
