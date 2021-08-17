package com.example.core.repository.consultation.di

import com.example.core.repository.consultation.repository.SearchPhotosRepository
import com.example.core.repository.consultation.repository.SearchPhotosRepositoryImpl
import com.example.core.repository.consultation.service.RetrofitConsultationService
import com.example.core.repository.consultation.usecases.GetPhotosByQueryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object SearchPhotosRepositoryModule {

    @Singleton
    @Provides
    fun providePictureRepository(
            consultationService: RetrofitConsultationService
    ): SearchPhotosRepository {
        return SearchPhotosRepositoryImpl(consultationService)
    }
}