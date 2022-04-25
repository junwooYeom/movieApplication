package com.junwooyeom.domain

import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {

    fun getFavoriteList(): Flow<List<Movie>>

    fun addToFavorite(movie: Movie)

    fun deleteToFavorite(movie: Movie)

}
