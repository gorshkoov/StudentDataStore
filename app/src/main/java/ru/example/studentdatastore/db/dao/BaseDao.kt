package ru.example.studentdatastore.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj : T) : Long
}