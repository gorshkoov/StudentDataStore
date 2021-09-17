package ru.example.studentdatastore.db.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.db.entity.University

@Dao
interface UniversityDao: BaseDao<University> {
    @Query("SELECT * FROM University")
    fun getUniversities(): Flow<List<University>>
}