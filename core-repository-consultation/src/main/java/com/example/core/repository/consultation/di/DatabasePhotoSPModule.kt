package com.example.core.repository.consultation.di

import android.content.Context
import androidx.room.Room
import com.example.core.repository.consultation.room.PhotoSPDao
import com.example.core.repository.consultation.room.PhotoSPRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabasePhotoSPModule {

    @Singleton
    @Provides
    fun providePhotoSPDatabase(@ApplicationContext context: Context): PhotoSPRoomDatabase {
        return Room.databaseBuilder(
            context, PhotoSPRoomDatabase::class.java,
            PhotoSPRoomDatabase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePictureLBCDao(database: PhotoSPRoomDatabase): PhotoSPDao {
        return database.pictureLBCDao()
    }
}