package com.rosewhat.harrypotter.domain.usecases

import com.rosewhat.harrypotter.domain.models.Faculty
import com.rosewhat.harrypotter.domain.repository.HatRepository

class GenerateFacultyUseCase(private val hatRepository: HatRepository) {
    suspend fun generateFaculty(userName: String): Faculty {
        return hatRepository.generateFaculty(userName = userName)
    }
}