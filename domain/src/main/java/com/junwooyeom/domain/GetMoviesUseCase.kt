package com.junwooyeom.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String) : Flow<PagingData<Movie>> = movieRepository.getMovies(query)
}