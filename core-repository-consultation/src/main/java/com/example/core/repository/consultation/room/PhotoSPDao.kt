package com.example.core.repository.consultation.room

import android.database.sqlite.SQLiteDatabase
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoSPDao {

    @Query("SELECT * FROM photosp_table ORDER BY id ASC")
    suspend fun getAllPictures(): List<Result>

    @Insert(onConflict = SQLiteDatabase.CONFLICT_REPLACE)
    suspend fun insert(photo: Result)

}