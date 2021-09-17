package ru.example.studentdatastore.repository

import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.db.entity.StudentFull

interface StudentRepository {
    fun getHeadman(): Flow<StudentFull?>

    suspend fun loadData()
}