package com.onix.internship.di

import com.onix.internship.ui.game.CanvasViewModel
import com.onix.internship.ui.game.FirstMoveViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { FirstMoveViewModel() }
    viewModel { CanvasViewModel() }
    viewModel { MainViewModel() }

}