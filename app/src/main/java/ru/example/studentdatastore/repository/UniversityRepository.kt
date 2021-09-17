package ru.example.studentdatastore.repository

import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.db.entity.University


interface UniversityRepository {
    fun getUniversities(): Flow<List<University>>

    suspend fun saveActiveUniversity(universityId: Long)

    suspend fun loadData()
}