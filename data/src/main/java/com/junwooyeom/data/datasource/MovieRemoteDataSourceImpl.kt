package com.junwooyeom.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.junwooyeom.data.datasource.paging.MoviePagingSource
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.domain.datasource.MovieRemoteDataSource
import com.junwooyeom.network.infraservice.MovieInfraService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieInfraService: MovieInfraService
) : MovieRemoteDataSource {
    override fun getMovies(query: String): Flow<PagingData<Movie>> =
        Pager(
            PagingConfig(pageSize = 10)
        ) {
            MoviePagingSource(movieInfraService, query)
        }.flow
}
