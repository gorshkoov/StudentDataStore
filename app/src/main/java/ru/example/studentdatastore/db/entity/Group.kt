package ru.example.studentdatastore.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group(
    @PrimaryKey
    val id: Long,
    val name: String
)
