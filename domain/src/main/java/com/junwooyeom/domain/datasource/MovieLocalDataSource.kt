package com.junwooyeom.domain.datasource

import com.junwooyeom.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {

    fun getFavoriteList(): Flow<List<Movie>>

    suspend fun addToFavorite(movie: Movie)

    suspend fun deleteToFavorite(movie: Movie)

}
