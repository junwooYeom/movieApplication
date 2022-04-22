package com.junwooyeom.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {

    fun getMovies(query: String): Flow<PagingData<Movie>>
}
