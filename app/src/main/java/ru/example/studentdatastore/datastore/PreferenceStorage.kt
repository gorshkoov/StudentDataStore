package ru.example.studentdatastore.datastore

import kotlinx.coroutines.flow.Flow


interface PreferenceStorage {
    suspend fun putActiveGroup(groupId: Long)

    val activeGroupIdFlow: Flow<Long>

    suspend fun putActiveUniversity(universityId: Long)

    val activeUniversityIdFlow: Flow<Long>
}