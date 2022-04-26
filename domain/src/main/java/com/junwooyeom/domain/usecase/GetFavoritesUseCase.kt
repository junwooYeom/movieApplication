package com.junwooyeom.domain.usecase

import com.junwooyeom.domain.model.Movie
import com.junwooyeom.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    operator fun invoke(): Flow<List<Movie>> = movieRepository.getFavoriteList()
}