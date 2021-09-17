package ru.example.studentdatastore.db.entity

import androidx.room.Embedded
import androidx.room.Relation

class StudentFull(
    @Embedded
    val student: Student,
    @Relation(parentColumn = "groupId", entityColumn = "id")
    val group: Group,
    @Relation(parentColumn = "universityId", entityColumn = "id")
    val university: University
)