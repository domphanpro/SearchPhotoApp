package com.example.core.repository.consultation.service

import com.example.core.repository.consultation.ConfigAPI.API_KEY
import com.example.core.repository.consultation.model.SearchPhotosResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitConsultationService {

    @GET("search/photos")
    suspend fun getPhotosSearch(
        @Query("client_id") clientId: String = API_KEY,
        @Query("query") query: String,
    ): SearchPhotosResponse

}