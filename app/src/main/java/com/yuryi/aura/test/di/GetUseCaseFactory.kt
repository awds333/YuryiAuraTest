package com.yuryi.aura.test.di

import com.yuryi.aura.test.domain.usecase.core.UseCase
import com.yuryi.aura.test.domain.usecase.core.UseCaseFactory
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope

inline fun <reified U : UseCase> Scope.getUseCaseFactory(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
): UseCaseFactory<U> =
    UseCaseFactory { get(qualifier, parameters) }
