package com.junwooyeom.domain.repository

import androidx.paging.PagingData
import com.junwooyeom.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(query: String): Flow<PagingData<Movie>>

    fun getFavoriteList(): Flow<List<Movie>>

    suspend fun addToFavorite(movie: Movie)

    suspend fun deleteToFavorite(movie: Movie)
}
