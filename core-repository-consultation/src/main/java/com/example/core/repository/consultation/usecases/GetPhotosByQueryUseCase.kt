package com.example.core.repository.consultation.usecases

import com.example.core.repository.consultation.repository.SearchPhotosRepository
import javax.inject.Inject

class GetPhotosByQueryUseCase @Inject constructor(private val repository: SearchPhotosRepository) {

    operator fun invoke(query: String) = repository.getPhotosSearch(query)

}