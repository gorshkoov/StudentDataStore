package ru.example.studentdatastore.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.example.studentdatastore.datastore.DataStorePreferenceStorage
import ru.example.studentdatastore.datastore.PreferenceStorage

val Context.dataStore by preferencesDataStore(
    name = DataStorePreferenceStorage.PREFS_NAME
)

val dataStoreModule = module {
    single<PreferenceStorage> { DataStorePreferenceStorage(androidContext().dataStore) }
}