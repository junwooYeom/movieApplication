package com.example.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context
    ) : AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "movie-database.db"
    ).build()

    @Provides
    @Singleton
    fun providesMovieDao(
        appDatabase: AppDatabase
    ): MovieDao = appDatabase.movieDao()
}
