package com.rosewhat.harrypotter.ui.hat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rosewhat.harrypotter.data.HatRepositoryImpl
import com.rosewhat.harrypotter.domain.usecases.GenerateFacultyUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HatViewModel : ViewModel() {

    private val repository = HatRepositoryImpl()

    private val generateFaculty = GenerateFacultyUseCase(hatRepository = repository)

    private val _facultyName = MutableLiveData<String>()
    val facultyName: LiveData<String>
        get() = _facultyName

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getFacultyName(name: String, surname: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.IO) {
                delay(5000)
                _facultyName.postValue(
                    generateFaculty.generateFaculty(name = name,
                        surname = surname).name
                )
                _isLoading.postValue(false)

            }
        }
    }
}