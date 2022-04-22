package com.junwooyeom.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.junwooyeom.domain.Movie
import com.junwooyeom.domain.MovieRemoteDataSource
import com.junwooyeom.network.MovieInfraService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieInfraService: MovieInfraService
) : MovieRemoteDataSource{
    override fun getMovies(query: String): Flow<PagingData<Movie>> =
        Pager(
            PagingConfig(pageSize = 10)
        ) {
            MoviePagingSource(movieInfraService, query)
        }.flow
}
