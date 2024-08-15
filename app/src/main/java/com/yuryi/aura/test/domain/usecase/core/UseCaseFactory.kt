package com.yuryi.aura.test.domain.usecase.core

import kotlin.properties.ReadOnlyProperty

fun interface UseCaseFactory<U : UseCase> {
    fun create(): U
}

fun <U : UseCase> UseCaseFactory<U>.delegate(): ReadOnlyProperty<Any, U> =
    ReadOnlyProperty { _, _ -> create() }
