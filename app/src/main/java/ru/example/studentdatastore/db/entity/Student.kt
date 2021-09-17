package ru.example.studentdatastore.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey
    val id: Long,
    val name: String,
    val groupId: Long,
    val universityId: Long,
    val isHeadman: Boolean
)