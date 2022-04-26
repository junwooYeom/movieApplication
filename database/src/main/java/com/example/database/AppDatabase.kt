package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.MovieDao
import com.example.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
