package com.junwooyeom.network

import retrofit2.http.GET

interface MovieInfraService {
    @GET("/v1/search/movie.json")
    suspend fun getMoviesByQuery(): MovieResponse
}
