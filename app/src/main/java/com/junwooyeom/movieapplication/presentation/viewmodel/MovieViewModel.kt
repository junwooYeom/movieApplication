package com.junwooyeom.movieapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.junwooyeom.domain.usecase.GetMoviesUseCase
import com.junwooyeom.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    fun getMovie(query: String) : Flow<PagingData<Movie>> {
        return getMoviesUseCase(query).cachedIn(viewModelScope)
    }
}
