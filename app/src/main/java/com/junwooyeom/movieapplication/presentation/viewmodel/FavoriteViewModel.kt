package com.junwooyeom.movieapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junwooyeom.domain.usecase.GetFavoritesUseCase
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.domain.usecase.AddToFavoriteUseCase
import com.junwooyeom.domain.usecase.DeleteToFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val deleteToFavoriteUseCase: DeleteToFavoriteUseCase
) : ViewModel() {

    fun getFavorites(): Flow<List<Movie>> = getFavoritesUseCase()

    fun addToFavorite(movie: Movie) {
        viewModelScope.launch {
            addToFavoriteUseCase(movie)
        }
    }

    fun deleteToFavorite(movie: Movie) {
        viewModelScope.launch {
            deleteToFavoriteUseCase(movie)
        }
    }
}
