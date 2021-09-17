package ru.example.studentdatastore.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.example.studentdatastore.db.dao.GroupDao
import ru.example.studentdatastore.db.dao.StudentDao
import ru.example.studentdatastore.db.dao.UniversityDao
import ru.example.studentdatastore.db.entity.Group
import ru.example.studentdatastore.db.entity.Student
import ru.example.studentdatastore.db.entity.University

@Database(
    entities = [
        Student::class,
        Group::class,
        University::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    abstract fun groupDao(): GroupDao

    abstract fun universityDao(): UniversityDao
}