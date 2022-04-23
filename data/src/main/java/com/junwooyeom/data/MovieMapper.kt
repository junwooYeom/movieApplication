package com.junwooyeom.data

import com.junwooyeom.domain.Movie
import com.junwooyeom.network.MovieDto

fun MovieDto.toMovie(): Movie =
    Movie(
        title,
        link,
        image,
        subtitle,
        pubDate,
        director,
        actor,
        userRating
    )
