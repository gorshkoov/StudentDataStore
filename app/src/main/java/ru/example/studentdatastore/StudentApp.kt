package ru.example.studentdatastore

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.example.studentdatastore.di.dataStoreModule
import ru.example.studentdatastore.di.dbModule
import ru.example.studentdatastore.di.mainModule
import ru.example.studentdatastore.di.repositoryModule


class StudentApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@StudentApp)
            modules(
                dbModule,
                dataStoreModule,
                repositoryModule,
                mainModule
            )
        }
    }
}