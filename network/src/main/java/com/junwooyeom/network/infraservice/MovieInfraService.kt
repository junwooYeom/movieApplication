package com.junwooyeom.network.infraservice

import com.junwooyeom.network.model.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInfraService {
    @GET("v1/search/movie.json")
    suspend fun getMoviesByQuery(
        @Query("query") query: String,
        @Query("start") start: Int,
    ): MovieResponse
}
