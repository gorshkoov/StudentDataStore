package ru.example.studentdatastore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(
    private val interactor: MainInteractor
) : ViewModel() {

    val headManFlow = interactor.getHeadman()
    val groupsFlow = interactor.getGroups()
    val universitiesFlow = interactor.getUniversities()

    fun onLoadDataClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.loadData()
        }
    }

    fun onChangeUniversityClicked(universityId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.saveActiveUniversity(universityId)
        }
    }

    fun onChangeGroupClicked(groupId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.saveActiveGroup(groupId)
        }
    }
}