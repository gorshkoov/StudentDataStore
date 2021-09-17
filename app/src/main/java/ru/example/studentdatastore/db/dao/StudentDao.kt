package ru.example.studentdatastore.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.db.entity.Student
import ru.example.studentdatastore.db.entity.StudentFull

@Dao
interface StudentDao: BaseDao<Student> {
    @Transaction
    @Query("SELECT * FROM Student WHERE groupId = :groupId AND universityId = :universityId AND isHeadman = 1")
    fun getHeadmanStudent(groupId: Long, universityId: Long): Flow<StudentFull?>
}