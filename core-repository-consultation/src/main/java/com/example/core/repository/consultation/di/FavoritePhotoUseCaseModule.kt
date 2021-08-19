package com.example.core.repository.consultation.di

import com.example.core.repository.consultation.repository.FavoriteRepository
import com.example.core.repository.consultation.usecases.FavoritePhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FavoritePhotoUseCaseModule {

    @Singleton
    @Provides
    fun provideGetPhotosByQueryUseCase(
            repository: FavoriteRepository
    ): FavoritePhotosUseCase {
        return FavoritePhotosUseCase(repository)
    }

}