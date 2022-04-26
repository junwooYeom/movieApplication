package com.junwooyeom.domain

import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {

    fun getFavoriteList(): Flow<List<Movie>>

    suspend fun addToFavorite(movie: Movie)

    suspend fun deleteToFavorite(movie: Movie)

}
