package com.example.core.repository.consultation.repository

import com.example.core.model.DataState
import com.example.core.model.consultation.SearchPhotos
import kotlinx.coroutines.flow.Flow

interface SearchPhotosRepository {
    fun getPhotosSearch(query: String): Flow<DataState<SearchPhotos>>
}