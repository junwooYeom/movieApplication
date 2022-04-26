package com.junwooyeom.network.model.response

import com.google.gson.annotations.SerializedName
import com.junwooyeom.network.model.dto.MovieDto

data class MovieResponse(
    @SerializedName("total")
    val total: Int,
    @SerializedName("start")
    val start: Int,
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val items: List<MovieDto>
)
