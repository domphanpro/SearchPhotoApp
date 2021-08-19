package com.example.core.repository.consultation.repository

import com.example.core.model.DataState
import com.example.core.model.consultation.Result
import com.example.core.repository.consultation.room.Result as ResultPhotoDB
import com.example.core.repository.consultation.converters.toModel
import com.example.core.repository.consultation.room.PhotoSPDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoritePhotosRepositoryImpl constructor(
    private val photoSPDao: PhotoSPDao
) : FavoriteRepository {

    override fun getPhotosFavorite(): Flow<DataState<List<Result>>> = flow {
        emit(DataState.Loading)
        try {
            val networkPhotosSearch = photoSPDao.getAllPictures()
            val photosSearchModel = networkPhotosSearch.map { it.toModel() }
            emit(DataState.Success(photosSearchModel))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

    override suspend fun insertPhoto(photo: ResultPhotoDB) {
        photoSPDao.insert(photo)
    }

}