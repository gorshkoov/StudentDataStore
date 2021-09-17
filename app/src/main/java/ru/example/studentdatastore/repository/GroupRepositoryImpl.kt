package ru.example.studentdatastore.repository

import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.datastore.PreferenceStorage
import ru.example.studentdatastore.db.dao.GroupDao
import ru.example.studentdatastore.db.entity.Group

class GroupRepositoryImpl(
    private val dao: GroupDao,
    private val storage: PreferenceStorage
): GroupRepository {
    override fun getGroups(): Flow<List<Group>> =
        dao.getGroups()

    override suspend fun saveActiveGroup(groupId: Long) =
        storage.putActiveGroup(groupId)

    override suspend fun loadData() {
        val groups = listOf(
            Group(1, "Developers"),
            Group(2, "Painters"),
            Group(3, "Designers"),
            Group(4, "Models")
        )
        dao.insert(groups)
    }

}