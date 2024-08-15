package com.yuryi.aura.test.domain.model

import kotlinx.datetime.LocalDate

data class BootEventsForDate(val date: LocalDate, val bootEvents: List<BootEvent>)
