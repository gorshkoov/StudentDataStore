package ru.example.studentdatastore.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.example.studentdatastore.db.AppDataBase

private const val DB_NAME = "test_db"

val dbModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDataBase::class.java, DB_NAME)
            .build()
    }

    single { (get() as AppDataBase).studentDao() }
    single { (get() as AppDataBase).groupDao() }
    single { (get() as AppDataBase).universityDao() }
}