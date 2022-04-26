package com.junwooyeom.data

import com.example.database.MovieDao
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.domain.datasource.MovieLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : MovieLocalDataSource {
    override fun getFavoriteList(): Flow<List<Movie>> {
        return movieDao.getFavorite().map { data -> data.map { it.toMovie() } }
    }

    override suspend fun addToFavorite(movie: Movie) {
        movieDao.addToFavorite(movie.toMovieEntity())
    }

    override suspend fun deleteToFavorite(movie: Movie) {
        movieDao.deleteToFavorite(movie.toMovieEntity())
    }
}
