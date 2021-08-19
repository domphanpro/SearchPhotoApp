package com.example.core.repository.consultation.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Result::class],
    version = PhotoSPRoomDatabase.DB_VERSION,
    exportSchema = false
)
abstract class PhotoSPRoomDatabase : RoomDatabase() {

    abstract fun pictureLBCDao(): PhotoSPDao

    companion object {

        const val DB_VERSION = 1
        const val DB_NAME = "photosp_database"

    }
}