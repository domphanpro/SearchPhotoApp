package com.example.core.repository.consultation.di

import com.example.core.repository.consultation.service.RetrofitConsultationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitConsultationModule {

    @Singleton
    @Provides
    fun provideConsultationService(retrofit: Retrofit.Builder): RetrofitConsultationService {
        return retrofit
            .build()
            .create(RetrofitConsultationService::class.java)
    }
}