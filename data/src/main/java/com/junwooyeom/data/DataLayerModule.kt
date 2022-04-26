package com.junwooyeom.data

import com.example.database.MovieDao
import com.junwooyeom.domain.MovieLocalDataSource
import com.junwooyeom.domain.MovieRemoteDataSource
import com.junwooyeom.domain.MovieRepository
import com.junwooyeom.network.MovieInfraService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataLayerModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource(infraService: MovieInfraService) : MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(infraService)

    @Provides
    @Singleton
    fun providesMovieRepository(
        remoteDataSource: MovieRemoteDataSource,
        localDataSource: MovieLocalDataSource
    ): MovieRepository =
        MovieRepositoryImpl(
            remoteDataSource,
            localDataSource
        )

    @Provides
    @Singleton
    fun provideLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)

}
