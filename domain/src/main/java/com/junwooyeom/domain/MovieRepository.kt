package com.junwooyeom.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(query: String): Flow<PagingData<Movie>>

    fun getFavoriteList(): Flow<List<Movie>>

    fun addToFavorite(movie: Movie)

    fun deleteToFavorite(movie: Movie)
}
