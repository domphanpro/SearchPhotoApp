package com.example.core.repository.consultation.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photosp_table")
class Result(
        @PrimaryKey val id: String,
        val alt_description: String?,
        val description: String?,
        val created_at: String,
        val urls: String,
)