package ru.example.studentdatastore.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import ru.example.studentdatastore.datastore.PreferenceStorage
import ru.example.studentdatastore.db.dao.StudentDao
import ru.example.studentdatastore.db.entity.Student
import ru.example.studentdatastore.db.entity.StudentFull

class StudentRepositoryImpl(
    private val dao: StudentDao,
    private val storage: PreferenceStorage
) : StudentRepository {
    override fun getHeadman(): Flow<StudentFull?> =
        combine(storage.activeGroupIdFlow, storage.activeUniversityIdFlow)
        { group, university -> group to university }
            .flatMapLatest { pair -> dao.getHeadmanStudent(pair.first, pair.second) }

    override suspend fun loadData() {
        val students = listOf(
            Student(1, "Ivanov Ivan", 1, 1, false),
            Student(2, "Ivanov Petr", 1, 1, true),
            Student(3, "Ivanov Vasil", 2, 1, true),
            Student(4, "Petrov Petr", 3, 2, true),
            Student(5, "Petrov Ivan", 4, 3, false),
            Student(6, "Sidorov Ivan", 1, 4, true),
            Student(7, "Sidorov Alex", 1, 3, false),
        )
        dao.insert(students)
    }
}