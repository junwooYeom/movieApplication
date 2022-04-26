package com.junwooyeom.domain.usecase

import com.junwooyeom.domain.model.Movie
import com.junwooyeom.domain.repository.MovieRepository
import javax.inject.Inject

class AddToFavoriteUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) = movieRepository.addToFavorite(movie)
}