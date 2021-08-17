package com.example.core.repository.consultation.repository

import com.example.core.model.DataState
import com.example.core.model.consultation.SearchPhotos
import com.example.core.repository.consultation.converters.toModel
import com.example.core.repository.consultation.service.RetrofitConsultationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchPhotosRepositoryImpl constructor(
    private val consultationService: RetrofitConsultationService
) : SearchPhotosRepository {

    override fun getPhotosSearch(query: String): Flow<DataState<SearchPhotos>> = flow {
        emit(DataState.Loading)
        try {
            val networkPhotosSearch = consultationService.getPhotosSearch(query = query)
            val photosSearchModel = networkPhotosSearch.toModel()
            emit(DataState.Success(photosSearchModel))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

}