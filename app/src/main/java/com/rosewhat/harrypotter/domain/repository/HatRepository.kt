package com.rosewhat.harrypotter.domain.repository

import com.rosewhat.harrypotter.domain.models.Faculty

interface HatRepository {

    suspend fun generateFaculty(userName: String) : Faculty
}