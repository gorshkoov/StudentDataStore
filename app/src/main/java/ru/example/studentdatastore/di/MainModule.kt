package ru.example.studentdatastore.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.example.studentdatastore.MainActivity
import ru.example.studentdatastore.MainInteractor
import ru.example.studentdatastore.MainViewModel

val mainModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(get()) }
        scoped { MainInteractor(get(), get(), get()) }
    }
}