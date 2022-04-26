package com.junwooyeom.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    operator fun invoke(): Flow<List<Movie>> = movieRepository.getFavoriteList()
}