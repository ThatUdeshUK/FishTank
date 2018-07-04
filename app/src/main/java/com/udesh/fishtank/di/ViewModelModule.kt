package com.udesh.fishtank.di

import com.udesh.fishtank.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}