package com.junwooyeom.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(query: String): Flow<PagingData<Movie>>

    fun getFavoriteList(): Flow<List<Movie>>

    suspend fun addToFavorite(movie: Movie)

    suspend fun deleteToFavorite(movie: Movie)
}
