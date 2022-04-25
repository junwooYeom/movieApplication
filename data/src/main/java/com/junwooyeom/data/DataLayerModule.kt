package com.junwooyeom.data

import com.junwooyeom.domain.MovieRemoteDataSource
import com.junwooyeom.domain.MovieRepository
import com.junwooyeom.network.MovieInfraService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
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
    fun bindsMovieRepository(dataSource: MovieRemoteDataSource): MovieRepository =
        MovieRepositoryImpl(dataSource)

}
