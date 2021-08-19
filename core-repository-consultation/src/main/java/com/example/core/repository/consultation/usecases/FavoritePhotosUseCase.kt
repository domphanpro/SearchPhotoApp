package com.example.core.repository.consultation.usecases

import com.example.core.model.consultation.Result
import com.example.core.repository.consultation.converters.toModel
import com.example.core.repository.consultation.repository.FavoriteRepository
import javax.inject.Inject

class FavoritePhotosUseCase @Inject constructor(private val repository: FavoriteRepository) {
    fun getPhotosFavorite() = repository.getPhotosFavorite()
    suspend fun insert(photo: Result) = repository.insertPhoto(photo.toModel())
}
