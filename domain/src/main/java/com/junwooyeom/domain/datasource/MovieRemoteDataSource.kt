package com.junwooyeom.domain.datasource

import androidx.paging.PagingData
import com.junwooyeom.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {

    fun getMovies(query: String): Flow<PagingData<Movie>>
}
