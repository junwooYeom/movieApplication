package com.junwooyeom.data

import com.junwooyeom.domain.MovieRemoteDataSource
import com.junwooyeom.domain.MovieRepository
import com.junwooyeom.network.MovieInfraService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DataLayerModule {

    @Binds
    abstract fun bindsRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl) : MovieRemoteDataSource

    @Binds
    abstract fun bindsMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}
