package com.junwooyeom.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.junwooyeom.domain.Movie
import com.junwooyeom.network.MovieInfraService

class MoviePagingSource(
   private val infraService: MovieInfraService,
   private val query: String
): PagingSource<Int, Movie>(){
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = infraService.getMoviesByQuery(query, nextPageNumber)
            LoadResult.Page(
                data = response.items.map { it.toMovie() },
                prevKey = null,
                nextKey = if (response.total == nextPageNumber) null else response.start + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
