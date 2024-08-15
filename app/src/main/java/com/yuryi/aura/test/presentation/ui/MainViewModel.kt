package com.yuryi.aura.test.presentation.ui

import androidx.lifecycle.viewModelScope
import com.yuryi.aura.test.domain.usecase.BootEventsForDatesUseCase
import com.yuryi.aura.test.domain.usecase.core.UseCaseFactory
import com.yuryi.aura.test.domain.usecase.core.delegate
import com.yuryi.aura.test.presentation.ui.core.MviViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    bootEventsForDatesUseCaseFactory: UseCaseFactory<BootEventsForDatesUseCase>,
    initialState: MainState = MainState(emptyList())
) : MviViewModel<MainState>(initialState) {

    private val bootEventsUseCase by bootEventsForDatesUseCaseFactory.delegate()

    init {
        bootEventsUseCase().onSuccess { bootEventsFlow ->
            viewModelScope.launch {
                bootEventsFlow.collect { bootEventsForDates ->
                    reduce {
                        it.copy(bootEventsForDates = bootEventsForDates)
                    }
                }
            }
        }
        // TODO: Handle case when UseCase fails
    }
}
