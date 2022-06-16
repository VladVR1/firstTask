package com.onix.internship.di

import com.onix.internship.repository.PreferenceStorage
import org.koin.dsl.module

val repositoryModule = module {
    single { PreferenceStorage(get()) }
}