package com.junwooyeom.network

import com.google.gson.annotations.SerializedName

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
