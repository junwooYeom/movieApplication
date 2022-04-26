package com.junwooyeom.domain

import javax.inject.Inject

class DeleteToFavoriteUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) = movieRepository.deleteToFavorite(movie)
}