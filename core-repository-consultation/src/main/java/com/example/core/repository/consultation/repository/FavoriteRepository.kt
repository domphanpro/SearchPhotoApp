package com.example.core.repository.consultation.repository

import com.example.core.model.DataState
import com.example.core.model.consultation.Result
import com.example.core.repository.consultation.room.Result as ResultPhotoDB
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getPhotosFavorite(): Flow<DataState<List<Result>>>
    suspend fun insertPhoto(photo: ResultPhotoDB)
}