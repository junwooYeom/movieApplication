package com.junwooyeom.data

import androidx.paging.PagingData
import com.junwooyeom.domain.Movie
import com.junwooyeom.domain.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl : MovieRepository {
    override fun getMovies(): Flow<PagingData<Movie>> {
        TODO("Not yet implemented")
    }
}
