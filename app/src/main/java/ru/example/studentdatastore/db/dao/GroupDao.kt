package ru.example.studentdatastore.db.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.db.entity.Group

@Dao
interface GroupDao: BaseDao<Group> {
    @Query("SELECT * FROM `Group`")
    fun getGroups(): Flow<List<Group>>
}