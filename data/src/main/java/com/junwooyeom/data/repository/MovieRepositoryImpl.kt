package com.junwooyeom.data.repository

import androidx.paging.PagingData
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.domain.datasource.MovieLocalDataSource
import com.junwooyeom.domain.datasource.MovieRemoteDataSource
import com.junwooyeom.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource
) : MovieRepository {

    override fun getMovies(query: String): Flow<PagingData<Movie>> = remoteDataSource.getMovies(query)
    override fun getFavoriteList(): Flow<List<Movie>> = localDataSource.getFavoriteList()
    override suspend fun addToFavorite(movie: Movie) = localDataSource.addToFavorite(movie)
    override suspend fun deleteToFavorite(movie: Movie) = localDataSource.deleteToFavorite(movie)
}
