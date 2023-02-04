package com.rosewhat.harrypotter.data

import com.rosewhat.harrypotter.domain.models.Faculty
import com.rosewhat.harrypotter.domain.repository.HatRepository
import com.rosewhat.harrypotter.ui.hat.HatViewModel

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(userName: String): Faculty {
        return if (userName == "Harry Potter") {
            Faculty(name = FACULTY_GRYFFINDOR)
        } else {
            Faculty(name = FACULTY_SLYTHERIN)
        }
    }

    companion object {
        private const val FACULTY_GRYFFINDOR = "Gryffindor"
        private const val FACULTY_SLYTHERIN = "Slytherin"
    }
}