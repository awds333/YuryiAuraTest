package com.yuryi.aura.test.presentation.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

open class MviViewModel<S : State>(initialState: S) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    @OptIn(DelicateCoroutinesApi::class)
    private val reducerContext = newSingleThreadContext("ReducerContext in ${this::class.simpleName}")

    protected fun reduce(update: (S) -> S) {
        viewModelScope.launch(reducerContext) {
            _state.value = update(_state.value)
        }
    }
}
