package com.yuryi.aura.test.presentation.ui

import com.yuryi.aura.test.domain.model.BootEventsForDate
import com.yuryi.aura.test.presentation.ui.core.State

data class MainState(val bootEventsForDates: List<BootEventsForDate>): State
