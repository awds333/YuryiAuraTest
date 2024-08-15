package com.yuryi.aura.test.di

import com.yuryi.aura.test.presentation.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private val dataModule: Module
    get() = module {
        // TODO
    }

private val domainModule: Module
    get() = module {
        // TODO
    }

private val presentationModule: Module
    get() = module {
        viewModel {
            MainViewModel(getUseCaseFactory())
        }
    }

val appModules: Array<Module>
    get() = arrayOf(
        dataModule,
        domainModule,
        presentationModule
    )
