package com.junwooyeom.domain

import javax.inject.Inject

class AddToFavoriteUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) = movieRepository.addToFavorite(movie)
}