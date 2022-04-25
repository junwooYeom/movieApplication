package com.junwooyeom.data

import androidx.paging.PagingData
import com.junwooyeom.domain.Movie
import com.junwooyeom.domain.MovieLocalDataSource
import com.junwooyeom.domain.MovieRemoteDataSource
import com.junwooyeom.domain.MovieRepository
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
    override fun addToFavorite(movie: Movie) = localDataSource.addToFavorite(movie)
    override fun deleteToFavorite(movie: Movie) = localDataSource.deleteToFavorite(movie)
}
