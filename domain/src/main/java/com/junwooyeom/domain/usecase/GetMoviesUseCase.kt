package com.junwooyeom.domain.usecase

import androidx.paging.PagingData
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String) : Flow<PagingData<Movie>> = movieRepository.getMovies(query)
}