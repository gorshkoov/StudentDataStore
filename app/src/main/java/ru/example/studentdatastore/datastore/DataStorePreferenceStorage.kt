package ru.example.studentdatastore.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.example.studentdatastore.datastore.DataStorePreferenceStorage.PreferencesKeys.ACTIVE_GROUP_ID
import ru.example.studentdatastore.datastore.DataStorePreferenceStorage.PreferencesKeys.ACTIVE_UNIVERSITY_ID

class DataStorePreferenceStorage(
    private val dataStore: DataStore<Preferences>
) : PreferenceStorage {
    companion object {
        const val PREFS_NAME = "student_app"
    }

    object PreferencesKeys {
        val ACTIVE_GROUP_ID = longPreferencesKey("active_group_id")
        val ACTIVE_UNIVERSITY_ID = longPreferencesKey("active_university_id")
    }

    override suspend fun putActiveGroup(groupId: Long) {
        dataStore.edit { it[ACTIVE_GROUP_ID] = groupId }
    }

    override val activeGroupIdFlow: Flow<Long> = dataStore.data.map { it[ACTIVE_GROUP_ID] ?: 0L }

    override suspend fun putActiveUniversity(universityId: Long) {
        dataStore.edit { it[ACTIVE_UNIVERSITY_ID] = universityId }
    }

    override val activeUniversityIdFlow: Flow<Long> =
        dataStore.data.map { it[ACTIVE_UNIVERSITY_ID] ?: 0L }

}