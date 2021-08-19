package com.example.core.repository.consultation.usecases

import com.example.core.repository.consultation.repository.SearchPhotosRepository
import javax.inject.Inject

class GetPhotosByQueryUseCase @Inject constructor(private val repository: SearchPhotosRepository) {

    fun getPhotosSearch(query: String) = repository.getPhotosSearch(query)

}