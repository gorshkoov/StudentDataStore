package ru.example.studentdatastore.di

import org.koin.dsl.module
import ru.example.studentdatastore.repository.*

val repositoryModule = module {
    single<UniversityRepository> { UniversityRepositoryImpl(get(), get()) }
    single<StudentRepository> { StudentRepositoryImpl(get(), get()) }
    single<GroupRepository> { GroupRepositoryImpl(get(), get()) }
}