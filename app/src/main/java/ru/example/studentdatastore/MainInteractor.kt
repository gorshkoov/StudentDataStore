package ru.example.studentdatastore

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.example.studentdatastore.adapter.ListItem
import ru.example.studentdatastore.db.entity.StudentFull
import ru.example.studentdatastore.repository.GroupRepository
import ru.example.studentdatastore.repository.StudentRepository
import ru.example.studentdatastore.repository.UniversityRepository


class MainInteractor(
    private val groupRepository: GroupRepository,
    private val universityRepository: UniversityRepository,
    private val studentRepository: StudentRepository
) {
    suspend fun loadData() {
        groupRepository.loadData()
        universityRepository.loadData()
        studentRepository.loadData()
    }

    fun getHeadman(): Flow<StudentFull?> =
        studentRepository.getHeadman()
            .flowOn(Dispatchers.IO)

    fun getGroups(): Flow<List<ListItem>> =
        groupRepository.getGroups()
            .map { items -> items.map { ListItem(it.id, it.name) } }
            .flowOn(Dispatchers.IO)

    fun getUniversities(): Flow<List<ListItem>> =
        universityRepository.getUniversities()
            .map { items -> items.map { ListItem(it.id, it.name) } }
            .flowOn(Dispatchers.IO)

    suspend fun saveActiveUniversity(universityId: Long) {
        universityRepository.saveActiveUniversity(universityId)
    }

    suspend fun saveActiveGroup(groupId: Long) {
        groupRepository.saveActiveGroup(groupId)
    }
}