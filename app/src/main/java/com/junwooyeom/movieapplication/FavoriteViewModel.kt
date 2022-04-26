package com.junwooyeom.movieapplication

import androidx.lifecycle.ViewModel
import com.junwooyeom.domain.GetFavoritesUseCase
import com.junwooyeom.domain.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase
) : ViewModel() {

    fun getFavorites(): Flow<List<Movie>> = getFavoritesUseCase()

    fun addToFavorite(movie: Movie) {}

    fun deleteToFavorite(movie: Movie) {}
}