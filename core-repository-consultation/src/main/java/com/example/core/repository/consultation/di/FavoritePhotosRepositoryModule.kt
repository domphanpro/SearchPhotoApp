package com.example.core.repository.consultation.di

import com.example.core.repository.consultation.repository.FavoritePhotosRepositoryImpl
import com.example.core.repository.consultation.repository.FavoriteRepository
import com.example.core.repository.consultation.repository.SearchPhotosRepository
import com.example.core.repository.consultation.repository.SearchPhotosRepositoryImpl
import com.example.core.repository.consultation.room.PhotoSPDao
import com.example.core.repository.consultation.service.RetrofitConsultationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FavoritePhotosRepositoryModule {

    @Singleton
    @Provides
    fun provideFavoriteRepository(
        photoSPDao: PhotoSPDao
    ): FavoriteRepository {
        return FavoritePhotosRepositoryImpl(photoSPDao)
    }
}