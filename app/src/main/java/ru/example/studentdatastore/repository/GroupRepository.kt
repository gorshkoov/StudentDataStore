package ru.example.studentdatastore.repository

import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.db.entity.Group

interface GroupRepository {
    fun getGroups(): Flow<List<Group>>

    suspend fun saveActiveGroup(groupId: Long)

    suspend fun loadData()
}