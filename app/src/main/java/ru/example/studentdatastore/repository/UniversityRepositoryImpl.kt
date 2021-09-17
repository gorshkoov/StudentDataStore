package ru.example.studentdatastore.repository

import kotlinx.coroutines.flow.Flow
import ru.example.studentdatastore.datastore.PreferenceStorage
import ru.example.studentdatastore.db.dao.UniversityDao
import ru.example.studentdatastore.db.entity.University


class UniversityRepositoryImpl(
    private val dao: UniversityDao,
    private val storage: PreferenceStorage
): UniversityRepository {
    override fun getUniversities(): Flow<List<University>> =
        dao.getUniversities()

    override suspend fun saveActiveUniversity(universityId: Long) =
        storage.putActiveUniversity(universityId)

    override suspend fun loadData() {
        val universities = listOf(
            University(1, "MGU"),
            University(2, "BSTU"),
            University(3, "BGY"),
            University(4, "Bauman Uni"),
        )
        dao.insert(universities)
    }
}